package org.android.go.sopt.presentation.recycler

import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import org.android.go.sopt.databinding.ItemUserBinding
import org.android.go.sopt.model.user.ResponseUserDto

/**recycler view에 데이터-뷰 프로퍼티를 매칭해주는 클래스 -> Adapter의 필수 override 메서드에 쓰임*/
class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: ResponseUserDto.Data)=with(binding) {
        ivUser.load(item.avatar)
        tvUserName.text = String.format("%s %s",item.firstName,item.lastName)
        tvUserEmail.text = item.email
    }
}