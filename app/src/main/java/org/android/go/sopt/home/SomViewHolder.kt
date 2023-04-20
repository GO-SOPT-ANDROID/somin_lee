package org.android.go.sopt.home

import androidx.recyclerview.widget.RecyclerView
import org.android.go.sopt.databinding.ItemGodokSomBinding
import org.android.go.sopt.model.SomData

/**recycler view에 데이터-뷰 프로퍼티를 매칭해주는 클래스 -> Adapter의 필수 override 메서드에 쓰임*/
class SomViewHolder(private val binding : ItemGodokSomBinding): RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: SomData){
        binding.ivSom.setImageResource(item.imgId)
        binding.tvName.text = item.name
        binding.tvDetail.text = item.detail
    }
}