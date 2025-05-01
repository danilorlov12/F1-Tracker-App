package com.example.race_results.data.repository

import com.example.race_results.data.RaceResultsServiceAPI
import com.example.race_results.domain.RaceResultsRepository
import com.example.race_results.domain.RaceResultsResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RaceResultsRepositoryImpl @Inject constructor(
    private val serviceAPI: RaceResultsServiceAPI
) : RaceResultsRepository {

    override fun loadRaceResultsByYear(year: Int) = flow {
        emit(serviceAPI.loadRaceResultsByYear(year.toString()))
    }.map { result ->
        if (result.isSuccessful) {
            RaceResultsResult.Success(result.body())
        } else {
            RaceResultsResult.Error(result.message())
        }
    }.catch {
        emit(RaceResultsResult.Error(""))
    }
}