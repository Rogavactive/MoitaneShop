package com.example.moitaneshop.di

import com.example.moitaneshop.domain.usecase.GetAuthTokenUseCase
import com.example.moitaneshop.domain.usecase.GetShopsUseCase
import org.koin.dsl.module

internal val useCaseModule = module {
    factory { GetAuthTokenUseCase(get()) }
    factory { GetShopsUseCase(get(), get()) }
}