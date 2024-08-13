package com.rogoz208.mobileupcoingecko.presentation.coins_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rogoz208.mobileupcoingecko.common.Resource
import com.rogoz208.mobileupcoingecko.data.remote.dto.Currency
import com.rogoz208.mobileupcoingecko.domain.use_cases.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinsListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinsListState())
    val state: State<CoinsListState> = _state

    init {
        getCoins()
    }

    fun getCoins() {
        val currency = state.value.currency
        getCoinsUseCase(currency).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinsListState(
                        coins = result.data ?: emptyList(),
                        currency = currency
                    )
                }

                is Resource.Error -> {
                    _state.value =
                        CoinsListState(
                            error = result.message ?: "An unexpected error occurred",
                            currency = currency
                        )
                }

                is Resource.Loading -> {
                    _state.value = CoinsListState(isLoading = true, currency = currency)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onCurrencySelected(currency: Currency) {
        _state.value = state.value.copy(currency = currency)
        getCoins()
    }
}
