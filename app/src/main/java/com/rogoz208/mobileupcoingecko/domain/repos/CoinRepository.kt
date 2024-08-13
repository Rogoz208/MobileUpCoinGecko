package com.rogoz208.mobileupcoingecko.domain.repos

import com.rogoz208.mobileupcoingecko.data.remote.dto.CoinDTO
import com.rogoz208.mobileupcoingecko.data.remote.dto.CoinDetailsDTO

interface CoinRepository {

    suspend fun getCoins(currency: String): List<CoinDTO>

    suspend fun getCoinDetailsById(coinId: String): CoinDetailsDTO
}