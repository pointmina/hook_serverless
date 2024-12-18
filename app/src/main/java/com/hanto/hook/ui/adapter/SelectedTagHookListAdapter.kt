package com.hanto.hook.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hanto.hook.data.model.Hook
import com.hanto.hook.databinding.ItemSelectedTagHookListBinding

class SelectedTagHookListAdapter(
    private var hooks: ArrayList<Hook>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<SelectedTagHookListAdapter.SelectedTagHookViewHolder>() {

    interface OnItemClickListener {
        fun onClick(position: Int)
        fun onOptionButtonClick(position: Int)
    }

    // 뷰홀더 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedTagHookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSelectedTagHookListBinding.inflate(inflater, parent, false)
        return SelectedTagHookViewHolder(binding)
    }

    // 데이터와 뷰 바인딩
    override fun onBindViewHolder(holder: SelectedTagHookViewHolder, position: Int) {
        holder.bind(hooks[position])
    }

    // 아이템 개수 반환
    override fun getItemCount(): Int = hooks.size


    // 특정 위치의 Hook 객체 반환
    fun getItem(position: Int): Hook = hooks[position]

    // 뷰홀더 클래스
    inner class SelectedTagHookViewHolder(private val binding: ItemSelectedTagHookListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(hook: Hook) {
            with(binding) {
                tvTitle.text = hook.title
                tvUrlLink.text = hook.url
                tvTagDescription.text = hook.description

                if (!hook.description.isNullOrEmpty()) {
                    binding.tvTagDescription.visibility = View.VISIBLE
                    binding.tvTagDescription.text = hook.description
                } else {
                    binding.tvTagDescription.visibility = View.GONE
                }

                root.setOnClickListener {
                    listener.onClick(adapterPosition)
                }
                // ic_option 클릭 리스너 설정
                icOption.setOnClickListener {
                    listener.onOptionButtonClick(adapterPosition)
                }
            }
        }
    }
}
