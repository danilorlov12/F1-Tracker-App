package com.example.standings.ui.screens.driver

import com.example.drivers.model.DriverDetailsAssetModel
import com.example.race_results.model.RaceResultAssetModel
import com.example.standings.data.api_model.DriverStandingsApiModel
import com.example.standings.domain.drivers.DriverStandingsResult
import com.example.standings.ui.model.Driver
import javax.inject.Inject

class DriverStandingsUiMapper @Inject constructor() : DriverStandingsResult.Mapper<DriverStandingsUiState> {

    override fun mapSuccess(model: DriverStandingsApiModel?): DriverStandingsUiState {
        return DriverStandingsUiState.Success(
            drivers = model?.drivers?.map {
                Driver(
                    id = it.driver.id,
                    name = "${it.driver.lastName} ${it.driver.firstName[0]}.",
                    points = it.points,
                    place = it.place,
                    teamName = it.team.name
                )
            } ?: emptyList()
        )
    }

    override fun mapError(error: String): DriverStandingsUiState {
        return DriverStandingsUiState.Error(error)
    }

    override fun mapAsset(
        raceResults: List<RaceResultAssetModel>,
        drivers: List<DriverDetailsAssetModel>
    ): DriverStandingsUiState {
        val driverPointsMap = raceResults.groupBy { it.driverId }
            .mapValues { (_, results) ->
                results.sumOf { it.points }
            }

        val driversMap = raceResults.groupBy { it.driverId }

        return DriverStandingsUiState.Success(
            driverPointsMap.map { (id, points) ->
                Driver(
                    id = id,
                    name = "",
                    points = points,
                    place = 0,
                    teamName = ""
                )
            }
        )
    }
}