package org.android.go.sopt.presentation.recycler

import androidx.recyclerview.widget.RecyclerView
import org.android.go.sopt.databinding.ItemHeaderBinding
import org.android.go.sopt.model.RecycleAnimationData

/**recycler view에 데이터-뷰 프로퍼티를 매칭해주는 클래스 -> Adapter의 필수 override 메서드에 쓰임*/
class HeaderViewHolder(private val binding : ItemHeaderBinding): RecyclerView.ViewHolder(binding.root) {
    fun onBind(item : RecycleAnimationData){
        binding.tvHeader.text = item.detail
    }
}