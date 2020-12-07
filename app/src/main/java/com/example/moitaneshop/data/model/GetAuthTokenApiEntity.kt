package com.example.moitaneshop.data.model

import com.google.gson.annotations.SerializedName

data class GetAuthTokenApiEntity(
    @SerializedName("access_token") val accessToken: String? = null,
    @SerializedName("expires_in") val expiresIn: Long? = null, //Unix timestamp
    @SerializedName("token_type") val tokenType: String? = null
)
