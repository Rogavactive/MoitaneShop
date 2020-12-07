package com.example.moitaneshop.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moitaneshop.R
import com.example.moitaneshop.databinding.ItemShopBinding
import com.example.moitaneshop.presentation.model.ShopModel
import com.example.moitaneshop.presentation.model.ShopWorkingHour
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ShopItemRecyclerAdapter : RecyclerView.Adapter<ShopItemRecyclerAdapter.ViewHolder>() {

    private companion object {
        const val WEEKDAY_FORMAT = "EEEE"
    }

    private var data: List<ShopModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemShopBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        );
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

    inner class ViewHolder(private val binding: ItemShopBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private var workHoursVisible = false
            set(value) {
                if (value) {
                    binding.shopAvailableHours.visibility = View.VISIBLE
                } else {
                    binding.shopAvailableHours.visibility = View.GONE
                }
                field = value
            }

        fun onBind(item: ShopModel) = with(item) {
            binding.shopName.text = name
            binding.shopDelivery.text =
                if (deliveryFee > 0)
                    "$deliveryFee $"
                else
                    binding.root.context.getString(R.string.no_delivery)
            setStars(averageRating)
            binding.shopReviewCount.text = reviewsCount.toString()
            workingHours?.let {
                binding.shopAvailableHours.text = getAvailableHoursString(it)
                binding.root.setOnClickListener {
                    workHoursVisible = !workHoursVisible
                }
            }

            Glide
                .with(binding.root)
                .load(backgroundUrl)
                .centerCrop()
                .into(binding.shopBackground)

            // არ გვაქვს loadingImage და failureImage და შესაბამისად არ ვსეტავთ ამჯერად
            Glide
                .with(binding.root)
                .load(logoUrl)
                .centerCrop()
                .into(binding.shopLogo)


        }

        private fun getAvailableHoursString(hours: List<ShopWorkingHour>): String {
            val date = Calendar.getInstance().time
            val weekday = SimpleDateFormat(WEEKDAY_FORMAT, Locale.ENGLISH).format(date.time)
            val hourEntity = hours.firstOrNull { it.day.equals(weekday, ignoreCase = true) }
            return hourEntity?.let {
                if (it.working) {
                    "${it.day}, ${it.from} - ${it.to}"
                } else {
                    binding.root.context.getString(R.string.no_work)
                }
            } ?: ""
        }

        private fun setStars(starCount: Int) {
            binding.shopStarFirst.visibility = setStar(starCount, 1)
            binding.shopStarSecond.visibility = setStar(starCount, 2)
            binding.shopStarThird.visibility = setStar(starCount, 3)
            binding.shopStarFourth.visibility = setStar(starCount, 4)
            binding.shopStarFifth.visibility = setStar(starCount, 5)
        }

        private fun setStar(starCount: Int, requiredStars: Int): Int =
            if (starCount >= requiredStars)
                View.VISIBLE
            else
                View.GONE
    }

}