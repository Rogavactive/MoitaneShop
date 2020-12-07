package com.example.moitaneshop.domain.usecase

import com.example.moitaneshop.domain.repository.UserRepository
import io.reactivex.Completable

class GetAuthTokenUseCase(
    private val userRepository: UserRepository
) {

    operator fun invoke(): Completable = userRepository.getAuthToken()

}