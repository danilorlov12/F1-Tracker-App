package com.example.driver_details.domain

import com.example.driver_details.data.api_model.DriverDetailsApiModel
import com.example.drivers.model.DriverDetailsAssetModel
import com.example.teams.model.TeamDetailsAssetModel

interface DriverDetailsResult {

    fun <T : Any> map(mapper: Mapper<T>): T

    interface Mapper<T : Any> {

        fun mapSuccess(model: DriverDetailsApiModel?): T

        fun mapError(error: String): T

        fun mapAsset(driver: DriverDetailsAssetModel?, teams: List<TeamDetailsAssetModel>): T
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

    data class Asset(
        private val driver: DriverDetailsAssetModel?,
        private val teams: List<TeamDetailsAssetModel>
    ): DriverDetailsResult {
        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.mapAsset(driver, teams)
        }
    }
}