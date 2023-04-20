package org.android.go.sopt.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.android.go.sopt.databinding.ItemGodokSomBinding
import org.android.go.sopt.databinding.ItemHeaderBinding
import org.android.go.sopt.model.SomData

/**데이터 리스트(list<som>)를 뷰 리스트로 변환하는 클래스*/
class MultiViewAdapter(var itemList: List<SomData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //ViewHolder 구분을 위한 정수값
    val HEADER = 0
    val SOM = 1

    /**ViewHolder에 들어갈 View를 만들어주는 함수 (전체 리사이클러 뷰에 대한 내용)*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View?
        return when (viewType) {
            HEADER -> {
                HeaderViewHolder(
                    ItemHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
//            SOM -> {
//                SomViewHolder(
//                    ItemGodokSomBinding.inflate(
//                        LayoutInflater.from(parent.context),
//                        parent,
//                        false
//                    )
//                )
//            } //질문 => 분기를 3개로 하면 else문을 어떻게 처리해야 좋을지 모르겠다 !
            else -> {
                SomViewHolder(
                    ItemGodokSomBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    /**데이터 리스트의 아이템 갯수를 반환하는 함수*/
    override fun getItemCount() = itemList.size

    /**각각의 ViewHolder에 데이터를 매칭하는 함수(리사이클러 뷰의 아이템 각각에 대한 내용)*/
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewItem = itemList[position]
        when (viewItem.type) {
            0 -> {
                holder as HeaderViewHolder
                holder.onBind(viewItem)
                holder.setIsRecyclable(false)
            }
            1 -> {
                holder as SomViewHolder
                holder.onBind(viewItem)
                holder.setIsRecyclable(false)
            }
        }
    }

    /**뷰타입을 반환하는 함수*/
    override fun getItemViewType(position: Int): Int {
        return itemList[position].type
    }
}
