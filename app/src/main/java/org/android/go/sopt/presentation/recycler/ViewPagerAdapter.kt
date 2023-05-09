package org.android.go.sopt.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.android.go.sopt.databinding.ItemPagerBinding

class ViewPagerAdapter (_itemList: List<Int> = listOf(),): RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {
    lateinit var binding: ItemPagerBinding
    private var itemList: List<Int> = _itemList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        binding = ItemPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagerViewHolder(binding)
    }

    class PagerViewHolder(val binding : ItemPagerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(src: Int) {
        binding.ivPager.setImageResource(src)
        }
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount() = itemList.size

    fun setItemList(itemList: List<Int>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }
}