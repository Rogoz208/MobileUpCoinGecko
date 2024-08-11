package com.rogoz208.mobileupcoingecko.data.remote

import com.rogoz208.mobileupcoingecko.data.remote.dto.CoinDTO
import com.rogoz208.mobileupcoingecko.data.remote.dto.CoinDetailsDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinGeckoApi {

    @GET("/v3/coins/markets")
    suspend fun getCoins(): List<CoinDTO>

    @GET("/v3/coins/{coinId}")
    suspend fun getCoinDetailsById(@Path("coinId") coinId: String): CoinDetailsDTO
}