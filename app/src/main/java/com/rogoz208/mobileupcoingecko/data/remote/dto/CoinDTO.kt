package com.rogoz208.mobileupcoingecko.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.rogoz208.mobileupcoingecko.domain.model.Coin

data class CoinDTO(
    @SerializedName("current_price")
    val currentPrice: Double,
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

fun CoinDTO.toCoin(): Coin {
    return Coin(
        id = id,
        name = name,
        symbol = symbol,
        image = image,
        currentPrice = currentPrice,
        priceChangePercentage24h = priceChangePercentage24h,
    )
}