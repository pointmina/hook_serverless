package com.hanto.Hook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.hanto.Hook.databinding.FragmentHomeBinding
import okhttp3.internal.notify

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvUrlHookList.adapter = UrlHookListAdapter(getDummyData())

        // DividerItemDecoration에 대한 설정을 수정
        val dividerItemDecoration =
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        ResourcesCompat.getDrawable(resources, R.drawable.divider, null)?.let {
            dividerItemDecoration.setDrawable(it)
        }

        binding.rvUrlHookList.addItemDecoration(dividerItemDecoration)

        //리프레시 아이템 ㅇㅅㅇ 추가해야함
//        binding.refreshLayout.setOnRefreshListener {
//
//        }



        binding.ivAppbarAddHook.setOnClickListener {
            val action = HomeFragmentDirections.actionNavigationHomeToAddHookActivity()
            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
