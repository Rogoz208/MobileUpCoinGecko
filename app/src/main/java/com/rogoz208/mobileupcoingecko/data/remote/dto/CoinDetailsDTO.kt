package com.rogoz208.mobileupcoingecko.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.rogoz208.mobileupcoingecko.domain.model.CoinDetails

data class CoinDetailsDTO(
    @SerializedName("categories")
    val categories: List<String>,
    @SerializedName("description")
    val description: Description,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: Image,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String
)

fun CoinDetailsDTO.toCoinDetails(): CoinDetails {
    return CoinDetails(
        id = id,
        name = name,
        image = image,
        symbol = symbol,
        description = description,
        categories = categories
    )
}