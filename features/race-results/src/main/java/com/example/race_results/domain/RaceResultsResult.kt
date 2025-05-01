package com.example.race_results.domain

import com.example.race_results.data.api_model.RaceResultsApiModel

interface RaceResultsResult {

    fun <T : Any> map(mapper: Mapper<T>): T

    interface Mapper<T : Any> {

        fun mapSuccess(model: RaceResultsApiModel?): T

        fun mapError(error: String): T
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
}