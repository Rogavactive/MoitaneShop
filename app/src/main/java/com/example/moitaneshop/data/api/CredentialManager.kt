package com.example.moitaneshop.data.api

import com.example.moitaneshop.data.model.GetAuthTokenApiEntity

data class CredentialManager (
    var accessToken: String? = null,
    var expireTime: Long? = null,
    var tokenType: String? = null
) {

    fun tokenIsExpired(): Boolean {
        // რატომღაც 1000 -ზე გაყოფილი Unix Timestamp მოდის
        return (expireTime?: 0) * 1000L < System.currentTimeMillis() / 1000L
    }

    fun setToken(token: GetAuthTokenApiEntity) {
        accessToken = token.accessToken
        expireTime = token.expiresIn
        tokenType = token.tokenType
    }

}
