package com.example.moitaneshop.presentation.model

data class ShopModel(
    val id: Int,
    val name: String,
    val deliveryFee: Double,
    val averageRating: Int,
    val reviewsCount: Int,
    val logoUrl: String?,
    val backgroundUrl: String?,
    val workingHours: List<ShopWorkingHour>?
)

data class ShopWorkingHour(
    val day: String,
    val from: String,
    val to: String,
    val working: Boolean
)