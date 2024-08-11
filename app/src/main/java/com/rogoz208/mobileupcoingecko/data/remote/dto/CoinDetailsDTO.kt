package com.rogoz208.mobileupcoingecko.data.remote.dto

import com.google.gson.annotations.SerializedName

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