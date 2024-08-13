package com.rogoz208.mobileupcoingecko.domain.model

data class Coin(
    val currentPrice: Double,
    val id: String,
    val image: String,
    val name: String,
    val priceChangePercentage24h: Double,
    val symbol: String
)