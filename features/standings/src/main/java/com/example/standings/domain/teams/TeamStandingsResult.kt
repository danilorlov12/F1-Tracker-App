package com.example.standings.domain.teams

import com.example.race_results.model.RaceResultAssetModel
import com.example.standings.data.api_model.TeamStandingsApiModel
import com.example.teams.model.TeamDetailsAssetModel

interface TeamStandingsResult {

    fun <T : Any> map(mapper: Mapper<T>): T

    interface Mapper<T : Any> {

        fun mapSuccess(model: TeamStandingsApiModel?): T

        fun mapError(error: String): T

        fun mapAsset(raceResults: List<RaceResultAssetModel>, teams: List<TeamDetailsAssetModel>): T
    }

    data class Success(private val model: TeamStandingsApiModel?) : TeamStandingsResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapSuccess(model)
        }
    }

    data class Error(private val error: String) : TeamStandingsResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapError(error)
        }
    }

    data class Asset(
        private val raceResults: List<RaceResultAssetModel>,
        private val teams: List<TeamDetailsAssetModel>
    ) : TeamStandingsResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapAsset(raceResults, teams)
        }
    }
}