package com.example.standings.domain.drivers

import com.example.drivers.model.DriverDetailsAssetModel
import com.example.race_results.model.RaceResultAssetModel
import com.example.sprint_results.model.SprintResultAssetModel
import com.example.standings.data.api_model.DriverStandingsApiModel
import com.example.teams.model.TeamDetailsAssetModel

interface DriverStandingsResult {

    fun <T : Any> map(mapper: Mapper<T>): T

    interface Mapper<T : Any> {

        fun mapSuccess(model: DriverStandingsApiModel?): T

        fun mapError(error: String): T

        fun mapAsset(
            raceResults: List<RaceResultAssetModel>,
            sprintResults: List<SprintResultAssetModel>,
            drivers: List<DriverDetailsAssetModel>,
            teams: List<TeamDetailsAssetModel>
        ): T
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
        private val sprintResults: List<SprintResultAssetModel>,
        private val drivers: List<DriverDetailsAssetModel>,
        private val teams: List<TeamDetailsAssetModel>
    ) : DriverStandingsResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapAsset(raceResults, sprintResults, drivers, teams)
        }
    }
}