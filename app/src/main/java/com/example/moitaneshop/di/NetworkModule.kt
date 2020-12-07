package com.example.moitaneshop.di

import com.example.moitaneshop.BuildConfig
import com.example.moitaneshop.data.api.CredentialManager
import com.example.moitaneshop.data.api.MoitaneApi
import com.example.moitaneshop.data.api.RequestInterceptor
import com.example.moitaneshop.data.api.RetrofitClient
import org.koin.dsl.module

internal val networkModule = module {
    single { provideRestApi(get()) }
    single { provideCredentialManager() }
    single { provideRequestInterceptor(get()) }
}

private fun provideRestApi(requestInterceptor: RequestInterceptor): MoitaneApi {
    return RetrofitClient(requestInterceptor).provideApi(BuildConfig.BASE_URL)
}

private fun provideCredentialManager(): CredentialManager {
    return CredentialManager()
}

private fun provideRequestInterceptor(credentialManager: CredentialManager): RequestInterceptor {
    return RequestInterceptor(credentialManager)
}