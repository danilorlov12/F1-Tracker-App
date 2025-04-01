package com.example.standings.domain.drivers

import com.example.standings.data.api_model.DriverStandingsApiModel

interface DriverStandingsResult {

    fun <T : Any> map(mapper: Mapper<T>): T

    interface Mapper<T : Any> {

        fun mapSuccess(model: DriverStandingsApiModel?): T

        fun mapError(error: String): T
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
}