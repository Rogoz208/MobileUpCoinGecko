package com.rogoz208.mobileupcoingecko.domain.model

data class Coin(
    val current_price: Int,
    val id: String,
    val image: String,
    val name: String,
    val price_change_percentage_24h: Double,
    val symbol: String
)