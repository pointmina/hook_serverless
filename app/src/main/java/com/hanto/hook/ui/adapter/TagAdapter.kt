package com.hanto.hook.ui.adapter

import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hanto.hook.R
import com.hanto.hook.databinding.ItemTagTagBinding
import java.util.Collections

class TagAdapter(
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<TagAdapter.ViewHolder>() {


    interface OnItemClickListener {
        fun onClick(tagName: String)

    }

    var recyclerView: RecyclerView? = null
    private val tagList = mutableListOf<String>()

    inner class ViewHolder(val binding: ItemTagTagBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onClick(tagList[position])
                }
            }
        }


        fun bind(tagName: String) {
            binding.tvTagNameXl.text = tagName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTagTagBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tagList[position])
    }

    override fun getItemCount(): Int {
        return tagList.size
    }

    fun submitList(newTagList: List<String>) {
        val diffCallback = TagDiffCallback(tagList, newTagList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        tagList.clear()
        tagList.addAll(newTagList)
        diffResult.dispatchUpdatesTo(this)
    }

    fun getItem(position: Int): String? {
        return if (position in tagList.indices) tagList[position] else null
    }

    class TagDiffCallback(
        private val oldList: List<String>,
        private val newList: List<String>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size
        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }

    fun moveItem(fromPosition: Int, toPosition: Int) {
        if (fromPosition in tagList.indices && toPosition in tagList.indices) {
            val movedItem = tagList.removeAt(fromPosition)
            tagList.add(toPosition, movedItem)
            notifyItemMoved(fromPosition, toPosition)
        }
    }

    // 흔드는 애니메이션을 시작하는 메서드
    private fun startShakingAnimation(view: View) {
        val animator = ObjectAnimator.ofFloat(view, "rotation", -5f, 5f).apply {
            duration = 100 // 흔드는 속도
            repeatCount = ObjectAnimator.INFINITE // 무한 반복
            repeatMode = ObjectAnimator.REVERSE // 앞뒤로 왕복
        }
        animator.start()
        view.setTag(R.id.shake_animation, animator) // 애니메이터를 뷰에 저장
    }

    // 흔드는 애니메이션을 멈추는 메서드
    private fun stopShakingAnimation(view: View) {
        val animator = view.getTag(R.id.shake_animation) as? ObjectAnimator
        animator?.cancel()
        view.rotation = 0f // 초기 상태로 복원
    }

    // 드래그 중인 아이템을 제외하고 흔드는 애니메이션 시작
    fun startShakingExcept(selectedViewHolder: RecyclerView.ViewHolder?) {
        for (i in 0 until itemCount) {
            if (i == selectedViewHolder?.bindingAdapterPosition) continue // 선택된 아이템 제외
            val viewHolder = recyclerView?.findViewHolderForAdapterPosition(i) as? ViewHolder
            viewHolder?.itemView?.let { startShakingAnimation(it) }
        }
    }

    // 모든 아이템의 흔드는 애니메이션 멈춤
    fun stopShakingAll() {
        for (i in 0 until itemCount) {
            val viewHolder = recyclerView?.findViewHolderForAdapterPosition(i) as? ViewHolder
            viewHolder?.itemView?.let { stopShakingAnimation(it) }
        }
    }

}
