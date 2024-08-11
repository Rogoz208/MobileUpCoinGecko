package com.rogoz208.mobileupcoingecko.di

import com.rogoz208.mobileupcoingecko.common.Constants
import com.rogoz208.mobileupcoingecko.data.remote.CoinGeckoApi
import com.rogoz208.mobileupcoingecko.data.repos.CoinRepositoryImpl
import com.rogoz208.mobileupcoingecko.domain.repos.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinGeckoApi(): CoinGeckoApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinGeckoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinGeckoApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}