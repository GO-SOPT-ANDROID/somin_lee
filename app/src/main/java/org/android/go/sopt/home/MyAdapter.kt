package org.android.go.sopt.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.android.go.sopt.R
import org.android.go.sopt.databinding.ItemGodokSomBinding

class MyAdapter : RecyclerView.Adapter<MyViewHolder>(){

    private val itemList: List<Som> =
        listOf(Som(R.drawable.ic_launcher_foreground, "som1", "date1"), Som(R.drawable.ic_launcher_foreground, "som2", "date2"))

    //아래에 세가지 필수 매서드 자동 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding : ItemGodokSomBinding = ItemGodokSomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }
}

class MyViewHolder(private val binding : ItemGodokSomBinding):ViewHolder(binding.root) {
    fun onBind(item:Som){
        binding.tvItemDate.text = item.som
        binding.tvItemSomName.text = item.date
    }
}

data class Som(
    // 밑에 이상한 녀석이 있죠? 이는 안드로이드의 Meta Annotation입니다.
    @DrawableRes val pic: Int, // 서버에서 이미지 url이 내려오는 경우 String으로 받아야합니다. (Json 내부에는 URL 타입은 들어갈 수 없음)
    val som: String,
    val date: String
)