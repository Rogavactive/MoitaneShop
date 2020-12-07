package com.example.moitaneshop.domain.repository

import io.reactivex.Completable


interface UserRepository {

    fun getAuthToken(): Completable

}