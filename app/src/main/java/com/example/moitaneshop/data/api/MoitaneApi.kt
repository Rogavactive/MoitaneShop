package com.example.moitaneshop.data.api

import com.example.moitaneshop.data.model.GetAuthTokenApiEntity
import com.example.moitaneshop.data.model.MoitaneShopsApiEntity
import io.reactivex.Single
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Field
import retrofit2.http.GET

interface MoitaneApi {

    @POST("/connect/token")
    @FormUrlEncoded
    fun getAuthToken(
        @Field("grant_type")grantType: String,
        @Field("scope") scope: String,
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String
    ): Single<GetAuthTokenApiEntity>

    @GET("/v1/Shops")
    fun getShops(): Single<MoitaneShopsApiEntity>
}