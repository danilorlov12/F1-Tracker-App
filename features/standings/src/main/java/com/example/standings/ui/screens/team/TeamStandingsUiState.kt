package com.example.standings.ui.screens.team

import com.example.standings.ui.model.Team

interface TeamStandingsUiState {

    object Idle : TeamStandingsUiState

    object Loading : TeamStandingsUiState

    data class Success(val teams: List<Team>) : TeamStandingsUiState

    data class Error(val error: String) : TeamStandingsUiState
}