package org.android.go.sopt.presentation.recycler

import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import org.android.go.sopt.databinding.ItemUserBinding
import org.android.go.sopt.model.UserData

/**recycler view에 데이터-뷰 프로퍼티를 매칭해주는 클래스 -> Adapter의 필수 override 메서드에 쓰임*/
class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: UserData) {
        binding.ivUser.load(item.imgUrl)
        binding.tvUserName.text = item.name
        binding.tvUserEmail.text = item.email
    }
}