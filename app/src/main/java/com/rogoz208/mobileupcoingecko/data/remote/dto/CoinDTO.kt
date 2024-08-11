package com.rogoz208.mobileupcoingecko.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CoinDTO(
    @SerializedName("current_price")
    val currentPrice: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price_change_percentage_24h")
    val priceChangePercentage24h: Double,
    @SerializedName("symbol")
    val symbol: String
)