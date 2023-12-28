package com.example.cryptotest.models.remote.coinDetails

data class CoinDetailDto(
    val crypto: Crypto,
    val fiat: Fiat,
    val success: Boolean
)