package com.hanto.hook.ui.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hanto.hook.data.model.Hook
import com.hanto.hook.databinding.FragmentHomeBinding
import com.hanto.hook.ui.adapter.HookAdapter
import com.hanto.hook.util.BottomDialogHelper
import com.hanto.hook.viewmodel.HookViewModel

class HomeFragment : Fragment(), HookAdapter.OnItemClickListener {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val hookViewModel: HookViewModel by viewModels()
    private lateinit var adapter: HookAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HookAdapter(
            hooks = ArrayList(),
            hookViewModel = hookViewModel,
            lifecycleOwner = viewLifecycleOwner,
            onItemClickListener = this,
            onItemClick = { hook ->
                val intent = Intent(requireContext(), WebViewActivity::class.java).apply {
                    putExtra("HOOK_URL", hook.url)
                }
                startActivity(intent)
            }
        )

        binding.rvHome.adapter = adapter
        binding.rvHome.layoutManager = LinearLayoutManager(requireContext())

        val tvRecentHooks = binding.tvRecentHooks
        val svSearch = binding.svSearch

        // SearchView의 버튼 클릭 리스너 설정
        svSearch.setOnSearchClickListener {
            // TextView를 GONE 처리
            tvRecentHooks.visibility = View.GONE

            // SearchView를 부모 폭만큼 확장
            val params = svSearch.layoutParams
            params.width = LinearLayout.LayoutParams.MATCH_PARENT
            svSearch.layoutParams = params
        }

        // SearchView 닫기 버튼 리스너 설정
        svSearch.setOnCloseListener {
            // TextView 다시 보이기
            tvRecentHooks.visibility = View.VISIBLE

            // SearchView 크기 축소
            val params = svSearch.layoutParams
            params.width = 50.dpToPx()
            svSearch.layoutParams = params
            false
        }

        // 리사이클러뷰에 구분선 추가
        val dividerItemDecoration =
            DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        binding.rvHome.addItemDecoration(dividerItemDecoration)

        // liveDataHook을 관찰하여 데이터가 변경되면 어댑터에 업데이트
        hookViewModel.liveDataHook.observe(viewLifecycleOwner) { hooks: List<Hook> ->
            val layoutManager = binding.rvHome.layoutManager as LinearLayoutManager
            val currentPosition = layoutManager.findFirstVisibleItemPosition()
            val offset = layoutManager.findViewByPosition(currentPosition)?.top ?: 0


            val isNewDataAdded = hooks.size > adapter.itemCount

            val sortedHooks = hooks.sortedByDescending { it.id }
            adapter.updateHooks(sortedHooks) {
                val shimmerContainer = binding.sfLoading
                shimmerContainer.stopShimmer()
                shimmerContainer.visibility = View.GONE

                if (isNewDataAdded) {
                    binding.rvHome.scrollToPosition(0)
                } else {
                    layoutManager.scrollToPositionWithOffset(currentPosition, offset)
                }
            }
        }


        // 설정 버튼 클릭 리스너
//        val btSetting = view.findViewById<ImageButton>(R.id.bt_setting)
//        btSetting.setOnClickListener {
//            findNavController().navigate(R.id.action_navigation_home_to_settingActivity)
//        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(hook: Hook) {
    }

    override fun onOptionButtonClick(position: Int) {
        val selectedHook = adapter.getItem(position)
        BottomDialogHelper.showHookOptionsDialog(requireContext(), selectedHook, hookViewModel)
    }

    private fun Int.dpToPx(): Int {
        val density = resources.displayMetrics.density
        return (this * density).toInt()
    }
}
