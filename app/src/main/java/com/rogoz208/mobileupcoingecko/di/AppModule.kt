package com.rogoz208.mobileupcoingecko.di

import com.rogoz208.mobileupcoingecko.BuildConfig
import com.rogoz208.mobileupcoingecko.data.remote.CoinGeckoApi
import com.rogoz208.mobileupcoingecko.data.repos.CoinRepositoryImpl
import com.rogoz208.mobileupcoingecko.domain.repos.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient? = if (BuildConfig.DEBUG) {
        val logging = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    } else {
        null
    }

    @Provides
    @Singleton
    fun provideCoinGeckoApi(okHttpClient: OkHttpClient?): CoinGeckoApi = CoinGeckoApi(
        baseUrl = BuildConfig.COIN_GECKO_API_BASE_URL,
        apiKey = BuildConfig.COIN_GECKO_API_KEY,
        okHttpClient = okHttpClient
    )

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinGeckoApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}