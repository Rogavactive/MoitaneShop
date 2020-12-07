package com.example.moitaneshop.data.repository

import com.example.moitaneshop.data.api.MoitaneApi
import com.example.moitaneshop.domain.repository.ShopDataMapper
import com.example.moitaneshop.domain.repository.ShopRepository
import com.example.moitaneshop.presentation.model.ShopModel
import io.reactivex.Single


class ShopRepositoryImpl(
    private val api: MoitaneApi,
    private val shopDataMapper: ShopDataMapper
): ShopRepository {

    override fun getShops(): Single<List<ShopModel>> {
        return api.getShops()
            .map { it.shops }
            .map { elem -> shopDataMapper.transform(elem) }
    }

}