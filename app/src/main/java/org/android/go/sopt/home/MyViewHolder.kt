package org.android.go.sopt.home

import androidx.recyclerview.widget.RecyclerView
import org.android.go.sopt.databinding.ItemGodokSomBinding
import org.android.go.sopt.model.SomData

/**재활용하는 뷰에 데이터와 뷰의 프로퍼티를 매칭해주는 클래스 -> Adapter의 필수 override 메서드에 쓰임*/
class MyViewHolder(private val binding : ItemGodokSomBinding): RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: SomData){
        binding.ivSom.imageAlpha = item.image
        binding.tvItemDate.text = item.name
        binding.tvItemSomName.text = item.detail
    }
}