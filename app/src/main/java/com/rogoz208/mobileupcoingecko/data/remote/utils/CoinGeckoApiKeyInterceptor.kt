package com.rogoz208.mobileupcoingecko.data.remote.utils

import okhttp3.Interceptor
import okhttp3.Response

class CoinGeckoApiKeyInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain.proceed(
        chain.request().newBuilder()
            .addHeader("x-cg-demo-api-key", apiKey)
            .build()
    )
}