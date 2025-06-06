package com.example.standings.ui.screens.team

import com.example.core.providers.TeamLogoProvider
import com.example.race_results.model.RaceResultAssetModel
import com.example.sprint_results.model.SprintResultAssetModel
import com.example.standings.data.api_model.TeamStandingsApiModel
import com.example.standings.domain.teams.TeamStandingsResult
import com.example.standings.ui.model.Team
import com.example.teams.model.TeamDetailsAssetModel
import javax.inject.Inject

class TeamStandingsUiMapper @Inject constructor(
    private val teamLogoProvider: TeamLogoProvider
) : TeamStandingsResult.Mapper<TeamStandingsUiState> {

    override fun mapSuccess(model: TeamStandingsApiModel?): TeamStandingsUiState {
        return TeamStandingsUiState.Success(
            teams = model?.teams?.map {
                Team(
                    id = it.team.id,
                    name = it.team.name,
                    logoResId = teamLogoProvider.logoByTeamId(it.team.id),
                    points = it.points,
                    place = it.place
                )
            } ?: emptyList()
        )
    }

    override fun mapError(error: String): TeamStandingsUiState {
        return TeamStandingsUiState.Error(error)
    }

    override fun mapAsset(
        raceResults: List<RaceResultAssetModel>,
        sprintResults: List<SprintResultAssetModel>,
        teams: List<TeamDetailsAssetModel>
    ): TeamStandingsUiState {

        val raceTeamPointsMap = raceResults.groupBy { it.teamId }
            .mapValues { (_, results) ->
                results.sumOf { it.points }
            }

        val sprintTeamPointsMap = sprintResults.groupBy { it.teamId }
            .mapValues { (_, results) ->
                results.sumOf { it.points }
            }

        val totalPoints = (raceTeamPointsMap.keys + sprintTeamPointsMap.keys)
            .distinct()
            .associateWith { driverId ->
                (raceTeamPointsMap[driverId] ?: 0.0) + (sprintTeamPointsMap[driverId] ?: 0.0)
            }

        return TeamStandingsUiState.Success(
            teams.map {
                Team(
                    id = it.id,
                    name = it.name,
                    logoResId = teamLogoProvider.logoByTeamId(it.id),
                    points = totalPoints[it.id] ?: 0.0,
                    place = 0
                )
            }.sortedByDescending { it.points }.mapIndexed { index, team ->
                team.copy(place = index + 1)
            }
        )
    }
}