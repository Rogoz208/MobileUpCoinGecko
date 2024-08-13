package com.rogoz208.mobileupcoingecko.presentation.coins_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.rogoz208.mobileupcoingecko.R
import com.rogoz208.mobileupcoingecko.data.remote.dto.Currency
import com.rogoz208.mobileupcoingecko.data.remote.dto.names
import com.rogoz208.mobileupcoingecko.presentation.coins_list.components.CoinListItem
import com.rogoz208.mobileupcoingecko.presentation.coins_list.components.ErrorMessageWithRetryButton
import com.rogoz208.mobileupcoingecko.presentation.coins_list.components.TopAppBarWithChips

@Composable
fun CoinsListScreen(
    navController: NavController,
    viewModel: CoinsListViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBarWithChips(
                title = stringResource(id = R.string.app_name),
                items = Currency.entries.names(),
                onSelectedChanged = { itemIndex ->
                    viewModel.onCurrencySelected(Currency.entries[itemIndex])
                }
            )
        }
    ) { innerPadding ->

        val state = viewModel.state.value
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.coins) { coin ->
                    CoinListItem(coin = coin, currency = state.currency) {
                        TODO("Open details screen")
                    }
                }
            }
            if (state.error.isNotBlank()) {
                ErrorMessageWithRetryButton(
                    modifier = Modifier.fillMaxSize(),
                    message = "Произошла какая-то ошибка :(\n" +
                            "Попробуем снова?",
                    buttonLabel = "Попробовать",
                    onRetryButtonClicked = { viewModel.getCoins() }
                )
            }

            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}
