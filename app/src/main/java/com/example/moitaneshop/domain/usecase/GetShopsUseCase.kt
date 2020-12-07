package com.example.moitaneshop.domain.usecase

import com.example.moitaneshop.domain.repository.ShopRepository
import com.example.moitaneshop.presentation.model.ShopModel
import io.reactivex.Single

class GetShopsUseCase(
    private val shopRepository: ShopRepository,
    private val getAuthToken: GetAuthTokenUseCase
) {

    operator fun invoke(): Single<List<ShopModel>> =
        getAuthToken()
            .andThen(shopRepository.getShops())

}