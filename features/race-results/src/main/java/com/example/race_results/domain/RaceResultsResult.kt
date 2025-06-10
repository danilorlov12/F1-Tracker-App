package com.example.race_results.domain

import com.example.circuits.model.CircuitAssetModel
import com.example.drivers.model.DriverDetailsAssetModel
import com.example.grand_prixes.model.GrandPrixAssetModel
import com.example.race_results.data.api_model.RaceResultsApiModel
import com.example.race_results.model.RaceResultAssetModel
import com.example.seasons.model.SeasonAssetModel
import com.example.teams.model.TeamDetailsAssetModel

interface RaceResultsResult {

    fun <T : Any> map(mapper: Mapper<T>): T

    interface Mapper<T : Any> {

        fun mapSuccess(model: RaceResultsApiModel?): T

        fun mapError(error: String): T

        fun mapAsset(
            raceResults: List<RaceResultAssetModel>,
            drivers: List<DriverDetailsAssetModel>,
            teams: List<TeamDetailsAssetModel>,
            circuits: List<CircuitAssetModel>,
            grandPrixes: List<GrandPrixAssetModel>,
            seasons: List<SeasonAssetModel>
        ): T
    }

    data class Success(private val model: RaceResultsApiModel?) : RaceResultsResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapSuccess(model)
        }
    }

    data class Error(private val error: String) : RaceResultsResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapError(error)
        }
    }

    data class Asset(
        private val raceResults: List<RaceResultAssetModel>,
        private val drivers: List<DriverDetailsAssetModel>,
        private val teams: List<TeamDetailsAssetModel>,
        private val circuits: List<CircuitAssetModel>,
        private val grandPrixes: List<GrandPrixAssetModel>,
        private val seasons: List<SeasonAssetModel>
    ) : RaceResultsResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapAsset(raceResults, drivers, teams, circuits, grandPrixes, seasons)
        }
    }
}