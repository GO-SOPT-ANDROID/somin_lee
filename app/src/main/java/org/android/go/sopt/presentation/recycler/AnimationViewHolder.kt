package org.android.go.sopt.presentation.recycler
import androidx.recyclerview.widget.RecyclerView
import org.android.go.sopt.databinding.ItemAnimationBinding
import org.android.go.sopt.model.RecycleData

/**recycler view에 데이터-뷰 프로퍼티를 매칭해주는 클래스 -> Adapter의 필수 override 메서드에 쓰임*/
class AnimationViewHolder(private val binding : ItemAnimationBinding): RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: RecycleData){
        binding.ivAnimation.setImageResource(item.imgId)
        binding.tvAnimationName.text = item.name
        binding.tvAnimationDetail.text = item.detail
    }
}