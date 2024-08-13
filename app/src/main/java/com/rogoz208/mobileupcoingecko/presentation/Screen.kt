package com.rogoz208.mobileupcoingecko.presentation

sealed class Screen(val route: String) {
    data object CoinListScreen : Screen("coins_list_screen")
    data object CoinDetailScreen : Screen("coin_details_screen")
}