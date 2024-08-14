package com.rogoz208.mobileupcoingecko.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rogoz208.mobileupcoingecko.common.Constants
import com.rogoz208.mobileupcoingecko.common.Resource
import com.rogoz208.mobileupcoingecko.domain.use_cases.get_coin_details.GetCoinDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            _state.value = CoinDetailsState(isLoading = true, coinId = coinId)
            getCoin()
        }
    }

    fun getCoin() {
        val coinId = state.value.coinId
        getCoinDetailsUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinDetailsState(coin = result.data, coinId = coinId)
                }

                is Resource.Error -> {
                    _state.value = CoinDetailsState(
                        error = result.message ?: "An unexpected error occurred",
                        coinId = coinId
                    )
                }

                is Resource.Loading -> {
                    _state.value = CoinDetailsState(
                        isLoading = true,
                        coinId = coinId
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}