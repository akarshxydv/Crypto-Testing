package com.example.cryptotest.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtilities {

    const val apiKey = "0b35b7976de80aa3d7733b1f79a52808"
    const val baseUrl = "http://api.coinlayer.com/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}