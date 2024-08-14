package com.rogoz208.mobileupcoingecko.presentation.coin_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.rogoz208.mobileupcoingecko.R
import com.rogoz208.mobileupcoingecko.presentation.coin_details.components.CustomTopAppBar
import com.rogoz208.mobileupcoingecko.presentation.coins_list.components.ErrorMessageWithRetryButton

@Composable
fun CoinDetailsScreen(
    navController: NavController,
    viewModel: CoinDetailsViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CustomTopAppBar(
                title = stringResource(id = R.string.app_name),
                navigateBack = {
                    navController.popBackStack()
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
            LazyColumn(
                modifier = Modifier.padding(16.dp)
            ) {
                item {
                    state.coin?.let { coin ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            AsyncImage(
                                model = coin.image.large,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(90.dp)
                                    .clip(CircleShape)
                            )
                        }
                        Text(
                            modifier = Modifier.padding(bottom = 8.dp),
                            text = "Описание",
                            fontSize = 20.sp,
                            fontWeight = FontWeight(500)
                        )
                        Text(
                            modifier = Modifier.padding(bottom = 8.dp),
                            text = coin.description.en,
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400)
                        )
                        Text(
                            modifier = Modifier.padding(bottom = 8.dp),
                            text = "Категории",
                            fontSize = 20.sp,
                            fontWeight = FontWeight(500)
                        )
                        Text(
                            text = coin.categories.toString(),
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400)
                        )
                    }
                }
            }
            if (state.error.isNotBlank()) {
                ErrorMessageWithRetryButton(
                    modifier = Modifier.fillMaxSize(),
                    message = "Произошла какая-то ошибка :(\n" +
                            "Попробуем снова?",
                    buttonLabel = "Попробовать",
                    onRetryButtonClicked = { viewModel.getCoin() }
                )
            }

            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}