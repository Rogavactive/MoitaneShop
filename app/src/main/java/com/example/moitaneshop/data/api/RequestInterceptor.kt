package com.example.moitaneshop.data.api

import okhttp3.Interceptor
import okhttp3.Response

internal class RequestInterceptor(val credentialManager: CredentialManager) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        if (credentialManager.accessToken != null && !credentialManager.tokenIsExpired()) {
            req = req
                .newBuilder()
                .header(
                    "Authorization",
                    "${credentialManager.tokenType ?: "Bearer"} ${credentialManager.accessToken}"
                )
                .build()
        }
        return chain.proceed(req)
    }
}