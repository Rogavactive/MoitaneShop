package com.example.moitaneshop.data.model

data class MoitaneShopsApiEntity(
    val shops: List<MoitaneShopApiEntity>?,
    val httpStatusCode: Int,
    val userMessage: String?,
    val developerMessage: String?,
    val success: Boolean,
    val errors: List<String>?
)

data class MoitaneShopApiEntity(
    val id: Int,
    val name: String?,
    val description: String?,
    val address: String?,
    val logoUrl: String?,
    val backgroundUrl: String?,
    val orderNo: Int,
    val haveService: Boolean?,
    val estimatedTime: String?,
    val deliveryFee: Double,
    val averageRating:	Double,
    val reviewsCount:	Int,
    val lowerLimit: Double,
    val channel: String?,
    val isActive: Boolean,
    val latitude: Double,
    val longitude: Double,
    val workingHours: List<ShopWorkingHourApiEntity>?,
    val userPromoCode: Any? = null,
    val administratorsIds: String?
)

data class ShopWorkingHourApiEntity(
    val day: String?,
    val from: String?,
    val to: String?,
    val working: Boolean
)
