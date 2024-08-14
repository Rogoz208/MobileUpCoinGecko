package com.rogoz208.mobileupcoingecko.data.remote

import com.rogoz208.mobileupcoingecko.data.remote.dto.CoinDTO
import com.rogoz208.mobileupcoingecko.data.remote.dto.CoinDetailsDTO
import com.rogoz208.mobileupcoingecko.data.remote.dto.Currency
import com.rogoz208.mobileupcoingecko.data.remote.utils.CoinGeckoApiKeyInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinGeckoApi {

    @GET("/api/v3/coins/markets")
    suspend fun getCoins(
        @Query("vs_currency") currency: Currency,
        @Query("per_page") perPage: Int? = 30,
        @Query("page") page: Int? = 1
    ): List<CoinDTO>

    @GET("/api/v3/coins/{coinId}")
    suspend fun getCoinDetailsById(@Path("coinId") coinId: String): CoinDetailsDTO
}

fun CoinGeckoApi(
    baseUrl: String,
    apiKey: String,
    okHttpClient: OkHttpClient? = null
): CoinGeckoApi {

    val modifiedOkHttpClient = (okHttpClient?.newBuilder() ?: OkHttpClient.Builder())
        .addInterceptor(CoinGeckoApiKeyInterceptor(apiKey))
        .build()

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(modifiedOkHttpClient)
        .build()
        .create(CoinGeckoApi::class.java)
}