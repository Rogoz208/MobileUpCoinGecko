package com.rogoz208.mobileupcoingecko.presentation.coins_list

import com.rogoz208.mobileupcoingecko.data.remote.dto.Currency
import com.rogoz208.mobileupcoingecko.domain.model.Coin

data class CoinsListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val currency: Currency = Currency.USD,
    val error: String = ""
)
