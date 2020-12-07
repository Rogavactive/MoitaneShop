package com.example.moitaneshop.domain.repository

import com.example.moitaneshop.presentation.model.ShopModel
import io.reactivex.Single


interface ShopRepository {

    fun getShops(): Single<List<ShopModel>>

}