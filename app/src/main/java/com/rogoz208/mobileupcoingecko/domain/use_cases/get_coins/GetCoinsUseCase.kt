package com.rogoz208.mobileupcoingecko.domain.use_cases.get_coins

import com.rogoz208.mobileupcoingecko.common.Resource
import com.rogoz208.mobileupcoingecko.data.remote.dto.toCoin
import com.rogoz208.mobileupcoingecko.domain.model.Coin
import com.rogoz208.mobileupcoingecko.domain.repos.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repo: CoinRepository
) {

    operator fun invoke(currency: String): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repo.getCoins(currency).map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: retrofit2.HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}