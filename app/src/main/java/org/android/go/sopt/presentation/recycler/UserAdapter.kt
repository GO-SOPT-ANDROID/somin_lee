package org.android.go.sopt.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.android.go.sopt.databinding.ItemUserBinding
import org.android.go.sopt.model.user.ResponseUserDto

/**single viewHolder용 Adapter*/
class UserAdapter : RecyclerView.Adapter<UserViewHolder>() {
    private var itemList: List<ResponseUserDto.Data> = emptyList()

    //아래에 세가지 필수 매서드 자동 생성
    /**ViewHolder에 들어갈 View를 만들어주는 함수 (전체 리사이클러 뷰에 대한 내용)*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding: ItemUserBinding =
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    /**각각의 ViewHolder에 데이터를 매칭하는 함수(리사이클러 뷰의 아이템 각각에 대한 내용)*/
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    /**데이터 리스트의 아이템 갯수를 반환하는 함수*/
    override fun getItemCount() = itemList.size

    fun setUserList(userList: List<ResponseUserDto.Data>?) {
        if (userList != null) {
            this.itemList = userList.toList()
        }
        notifyDataSetChanged()
    }
}