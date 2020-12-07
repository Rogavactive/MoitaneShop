package com.example.moitaneshop.domain.repository

import com.example.moitaneshop.data.model.MoitaneShopApiEntity
import com.example.moitaneshop.data.model.ShopWorkingHourApiEntity
import com.example.moitaneshop.presentation.model.ShopModel
import com.example.moitaneshop.presentation.model.ShopWorkingHour
import kotlin.math.pow
import kotlin.math.roundToLong

class ShopDataMapper {

    fun transform(apiList: List<MoitaneShopApiEntity>?): List<ShopModel>? =
        apiList?.map { transform(it) }

    private fun transform(apiModel: MoitaneShopApiEntity): ShopModel = with(apiModel) {
        return ShopModel(
            id,
            name ?: "",
            deliveryFee.round(2),
            averageRating.round(2),
            reviewsCount,
            logoUrl,
            backgroundUrl,
            workingHours?.map { transform(it) }
        )
    }

    private fun transform(workingHour: ShopWorkingHourApiEntity): ShopWorkingHour =
        with(workingHour) {
            return ShopWorkingHour(
                day ?: "",
                from?.formatHours() ?: "",
                to?.formatHours() ?: "",
                working
            )
        }
}

fun String.formatHours(): String =
    if (this.lastIndexOf(":") != -1)
        this.substring(0, this.lastIndexOf(":"))
    else
        this

fun Double.round(digits: Int) : Double {
    val toPower = 10.0.pow(digits)
    return ((this * toPower).roundToLong() / toPower)
}