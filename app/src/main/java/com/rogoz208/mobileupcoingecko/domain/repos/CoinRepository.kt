package com.rogoz208.mobileupcoingecko.domain.repos

import com.rogoz208.mobileupcoingecko.data.remote.dto.CoinDTO
import com.rogoz208.mobileupcoingecko.data.remote.dto.CoinDetailsDTO
import com.rogoz208.mobileupcoingecko.data.remote.dto.Currency

interface CoinRepository {

    suspend fun getCoins(currency: Currency): List<CoinDTO>

    suspend fun getCoinDetailsById(coinId: String): CoinDetailsDTO
}