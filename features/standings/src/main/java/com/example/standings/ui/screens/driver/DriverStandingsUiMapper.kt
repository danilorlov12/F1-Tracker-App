package com.example.standings.ui.screens.driver

import com.example.drivers.model.DriverDetailsAssetModel
import com.example.race_results.model.RaceResultAssetModel
import com.example.sprint_results.model.SprintResultAssetModel
import com.example.standings.data.api_model.DriverStandingsApiModel
import com.example.standings.domain.drivers.DriverStandingsResult
import com.example.standings.ui.model.Driver
import com.example.teams.model.TeamDetailsAssetModel
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
        sprintResults: List<SprintResultAssetModel>,
        drivers: List<DriverDetailsAssetModel>,
        teams: List<TeamDetailsAssetModel>
    ): DriverStandingsUiState {

        val raceDriverPointsMap = raceResults.groupBy { it.driverId }
            .mapValues { (_, results) ->
                results.sumOf { it.points }
            }

        val sprintDriverPointsMap = sprintResults.groupBy { it.driverId }
            .mapValues { (_, results) ->
                results.sumOf { it.points }
            }

        val totalPoints = (raceDriverPointsMap.keys + sprintDriverPointsMap.keys)
            .distinct()
            .associateWith { driverId ->
                (raceDriverPointsMap[driverId] ?: 0.0) + (sprintDriverPointsMap[driverId] ?: 0.0)
            }

        return DriverStandingsUiState.Success(
            totalPoints.map { (id, points) ->
                val driver = drivers.first { it.id == id }
                val relatedRaces = raceResults.filter { it.driverId == id }.map { it.teamId }
                val relatedTeams = teams.filter { relatedRaces.contains(it.id) }

                Driver(
                    id = id,
                    name = "${driver.lastName} ${driver.firstName[0]}",
                    points = points,
                    place = 0,
                    teamName = relatedTeams.joinToString(" | ") { it.name }
                )
            }.sortedByDescending { it.points }.mapIndexed { index, driver ->
                driver.copy(place = index + 1)
            }
        )
    }
}