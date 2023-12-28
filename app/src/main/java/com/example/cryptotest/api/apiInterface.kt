package com.example.cryptotest.api

import com.example.cryptotest.models.remote.coinDetails.CoinDetailDto
import com.example.cryptotest.models.remote.coinRates.CoinRateDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface apiInterface {

    @GET("list")
    suspend fun getAllCoin(@Query("access_key") apiKey: String): Response<CoinDetailDto>

    @GET("live")
    suspend  fun getCoinRate(@Query("access_key") apiKey: String):Response<CoinRateDto>

}

