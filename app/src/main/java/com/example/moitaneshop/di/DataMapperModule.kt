package com.example.moitaneshop.di

import com.example.moitaneshop.domain.repository.ShopDataMapper
import org.koin.dsl.module

internal var dataMapperModule = module {
    single { ShopDataMapper() }
}
