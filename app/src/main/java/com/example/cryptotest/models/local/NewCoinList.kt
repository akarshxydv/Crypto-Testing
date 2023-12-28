package com.example.cryptotest.models.local

data class NewCoinList (
    val symbol: String,
    val name: String,
    val fullName: String,
    val iconUrl: String,
    val rate: Double
)
