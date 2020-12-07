package com.example.moitaneshop.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moitaneshop.databinding.ItemShopBinding
import com.example.moitaneshop.presentation.model.ShopModel

class ShopItemRecyclerAdapter: RecyclerView.Adapter<ShopItemRecyclerAdapter.ViewHolder>() {

    private var data: List<ShopModel> = ArrayList()

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

    fun setData(data: List<ShopModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: ItemShopBinding): RecyclerView.ViewHolder(itemView.root) {

        fun onBind(item: ShopModel) {
            // TODO: fill view with info.
        }
    }

}