package com.example.moitaneshop

import android.app.Application
import com.example.moitaneshop.di.*
import com.example.moitaneshop.di.networkModule
import com.example.moitaneshop.di.repositoryModule
import com.example.moitaneshop.di.useCaseModule
import com.example.moitaneshop.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                networkModule,
                repositoryModule,
                viewModelModule,
                useCaseModule,
                dataMapperModule
            )
        }
    }
}