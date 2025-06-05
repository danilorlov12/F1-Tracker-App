package com.example.standings.domain.drivers

import com.example.drivers.model.DriverDetailsAssetModel
import com.example.race_results.model.RaceResultAssetModel
import com.example.standings.data.api_model.DriverStandingsApiModel

interface DriverStandingsResult {

    fun <T : Any> map(mapper: Mapper<T>): T

    interface Mapper<T : Any> {

        fun mapSuccess(model: DriverStandingsApiModel?): T

        fun mapError(error: String): T

        fun mapAsset(raceResults: List<RaceResultAssetModel>, drivers: List<DriverDetailsAssetModel>): T
    }

    data class Success(private val model: DriverStandingsApiModel?) : DriverStandingsResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapSuccess(model)
        }
    }

    data class Error(private val error: String) : DriverStandingsResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapError(error)
        }
    }

    data class Asset(
        private val raceResults: List<RaceResultAssetModel>,
        private val drivers: List<DriverDetailsAssetModel>
    ) : DriverStandingsResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapAsset(raceResults, drivers)
        }
    }
}