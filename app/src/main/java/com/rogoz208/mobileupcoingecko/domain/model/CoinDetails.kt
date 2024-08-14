package com.rogoz208.mobileupcoingecko.domain.model

import com.rogoz208.mobileupcoingecko.data.remote.dto.Description
import com.rogoz208.mobileupcoingecko.data.remote.dto.Image

data class CoinDetails(
    val categories: List<String>,
    val description: Description,
    val id: String,
    val image: Image,
    val name: String,
    val symbol: String
)