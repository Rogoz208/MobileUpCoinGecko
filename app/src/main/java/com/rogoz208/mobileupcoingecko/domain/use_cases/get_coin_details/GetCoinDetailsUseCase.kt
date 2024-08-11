package com.rogoz208.mobileupcoingecko.domain.use_cases.get_coin_details

import com.rogoz208.mobileupcoingecko.common.Resource
import com.rogoz208.mobileupcoingecko.data.remote.dto.toCoinDetails
import com.rogoz208.mobileupcoingecko.domain.model.CoinDetails
import com.rogoz208.mobileupcoingecko.domain.repos.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailsUseCase @Inject constructor(
    private val repo: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repo.getCoinDetailsById(coinId).toCoinDetails()
            emit(Resource.Success(coin))
        } catch (e: retrofit2.HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}