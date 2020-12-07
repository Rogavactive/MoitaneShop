package com.example.moitaneshop.data.repository

import com.example.moitaneshop.BuildConfig
import com.example.moitaneshop.data.api.CredentialManager
import com.example.moitaneshop.data.api.MoitaneApi
import com.example.moitaneshop.domain.repository.UserRepository
import io.reactivex.Completable

class UserRepositoryImpl(
    private val api: MoitaneApi,
    private val credentialManager: CredentialManager
): UserRepository {

    private companion object {
        const val GRANT_TYPE = "client_credentials"
    }

    override fun getAuthToken(): Completable {
        return api.getAuthToken(
            GRANT_TYPE,
            BuildConfig.APP_CLIENT_SCOPE,
            BuildConfig.APP_CLIENT_ID,
            BuildConfig.APP_CLIENT_SECRET
        )
            .doOnSuccess {
                credentialManager.setToken(it)
            }
            .ignoreElement()
    }

}