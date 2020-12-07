package com.example.moitaneshop.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moitaneshop.domain.usecase.GetShopsUseCase
import com.example.moitaneshop.presentation.model.ShopModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

internal class MainPageViewModel(
    private val getShops: GetShopsUseCase
) : BaseViewModel() {

    private companion object {
        var queryString = ""
    }
    private var data: List<ShopModel> = ArrayList()

    private val _shopListLiveData = MutableLiveData<List<ShopModel>>()
    val shopListLiveData: LiveData<List<ShopModel>>
        get() = _shopListLiveData

    fun getShopList() {
        getShops()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                data = it
                filterShops(queryString)
            }, {})
            .addToCompositeDisposable()
    }

    fun filterShops(query: String) {
        queryString = query
        _shopListLiveData.postValue(data.filter{it.name == query})
    }

}