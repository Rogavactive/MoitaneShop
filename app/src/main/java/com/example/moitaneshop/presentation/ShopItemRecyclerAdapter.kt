package com.example.moitaneshop.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moitaneshop.databinding.ItemShopBinding

class ShopItemRecyclerAdapter: RecyclerView.Adapter<ShopItemRecyclerAdapter.ViewHolder>() {

    private var data: List<ShopItemUIModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemShopBinding.inflate(LayoutInflater.from(parent.context),
            parent, false));
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(data: List<ShopItemUIModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: ItemShopBinding): RecyclerView.ViewHolder(itemView.root) {

        fun onBind(item: ShopItemUIModel) {
            // TODO: fill view with info.
        }
    }

}