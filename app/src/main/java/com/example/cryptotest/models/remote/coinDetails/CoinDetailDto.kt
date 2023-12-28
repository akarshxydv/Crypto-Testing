package com.example.cryptotest.models.remote.coinDetails

data class CoinDetailDto(
    val crypto: HashMap<String, Coin>,
    val fiat: HashMap<String, String>,
    val success: Boolean
)

data class Coin(
    val symbol: String,
    val name: String,
    val name_full: String,
    val max_supply: String,
    val icon_url: String
)
