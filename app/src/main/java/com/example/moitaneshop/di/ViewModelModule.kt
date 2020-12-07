package com.example.moitaneshop.di

import com.example.moitaneshop.presentation.viewmodel.MainPageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal var viewModelModule = module {
    viewModel { MainPageViewModel(get()) }
}