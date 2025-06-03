package com.example.driver_details.domain

import com.example.driver_details.data.api_model.DriverDetailsApiModel

interface DriverDetailsResult {

    fun <T : Any> map(mapper: Mapper<T>): T

    interface Mapper<T : Any> {

        fun mapSuccess(model: DriverDetailsApiModel?): T

        fun mapError(error: String): T
    }

    data class Success(private val model: DriverDetailsApiModel?) : DriverDetailsResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapSuccess(model)
        }
    }

    data class Error(private val error: String) : DriverDetailsResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapError(error)
        }
    }
}