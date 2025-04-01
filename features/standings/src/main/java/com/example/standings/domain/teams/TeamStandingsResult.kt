package com.example.standings.domain.teams

import com.example.standings.data.api_model.TeamStandingsApiModel

interface TeamStandingsResult {

    fun <T : Any> map(mapper: Mapper<T>): T

    interface Mapper<T : Any> {

        fun mapSuccess(model: TeamStandingsApiModel?): T

        fun mapError(error: String): T
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
}