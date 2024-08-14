package com.rogoz208.mobileupcoingecko.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rogoz208.mobileupcoingecko.presentation.coin_details.CoinDetailsScreen
import com.rogoz208.mobileupcoingecko.presentation.coins_list.CoinsListScreen
import com.rogoz208.mobileupcoingecko.presentation.ui.theme.MobileUpCoinGeckoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileUpCoinGeckoTheme {
                Navigation()
            }
        }
    }

    @Composable
    private fun Navigation() {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Screen.CoinListScreen.route
        ) {
            composable(
                route = Screen.CoinListScreen.route
            ) {
                CoinsListScreen(navController)
            }
            composable(
                route = Screen.CoinDetailScreen.route + "/{coinId}"
            ) {
                CoinDetailsScreen(navController)
            }
        }
    }
}
