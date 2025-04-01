package com.example.standings.ui.screens.team

import com.example.standings.data.api_model.TeamStandingsApiModel
import com.example.standings.domain.teams.TeamStandingsResult
import com.example.standings.ui.model.Team
import javax.inject.Inject

class TeamStandingsUiMapper @Inject constructor() : TeamStandingsResult.Mapper<TeamStandingsUiState> {

    override fun mapSuccess(model: TeamStandingsApiModel?): TeamStandingsUiState {
        return TeamStandingsUiState.Success(
            teams = model?.teams?.map {
                Team(
                    id = it.team.id,
                    name = it.team.name,
                    logoResId = 0,
                    points = it.points,
                    place = it.place
                )
            } ?: emptyList()
        )
    }

    override fun mapError(error: String): TeamStandingsUiState {
        return TeamStandingsUiState.Error(error)
    }
}