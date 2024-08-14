package com.rogoz208.mobileupcoingecko.presentation.coin_details

import com.rogoz208.mobileupcoingecko.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coin: CoinDetails? = null,
    val coinId: String = "",
    val error: String = ""
)