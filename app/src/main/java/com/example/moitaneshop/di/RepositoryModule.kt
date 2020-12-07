package com.example.moitaneshop.di

import com.example.moitaneshop.data.repository.UserRepositoryImpl
import com.example.moitaneshop.data.repository.ShopRepositoryImpl
import com.example.moitaneshop.domain.repository.ShopRepository
import com.example.moitaneshop.domain.repository.UserRepository
import org.koin.dsl.module

internal var repositoryModule = module {
    single<UserRepository> { UserRepositoryImpl(get(), get()) }
    single<ShopRepository> { ShopRepositoryImpl(get(), get()) }
}