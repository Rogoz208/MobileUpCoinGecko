package com.rogoz208.mobileupcoingecko.data.repos

import com.rogoz208.mobileupcoingecko.data.remote.CoinGeckoApi
import com.rogoz208.mobileupcoingecko.data.remote.dto.CoinDTO
import com.rogoz208.mobileupcoingecko.data.remote.dto.CoinDetailsDTO
import com.rogoz208.mobileupcoingecko.data.remote.dto.Currency
import com.rogoz208.mobileupcoingecko.domain.repos.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinGeckoApi
) : CoinRepository {

    override suspend fun getCoins(currency: Currency): List<CoinDTO> {
        return api.getCoins(currency)
    }

    override suspend fun getCoinDetailsById(coinId: String): CoinDetailsDTO {
        return api.getCoinDetailsById(coinId)
    }
}