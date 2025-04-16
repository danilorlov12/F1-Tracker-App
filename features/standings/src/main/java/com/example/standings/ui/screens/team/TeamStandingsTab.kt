package com.example.standings.ui.screens.team

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.standings.ui.screens.StandingsViewModel
import com.example.standings.ui.screens.team.views.TopSongsSuccessScreen

@Composable
fun TeamStandingsTab(viewModel: StandingsViewModel) {
    val state by viewModel.teamState.collectAsState()

    when (val currentState = state) {
        is TeamStandingsUiState.Success -> TopSongsSuccessScreen(currentState.teams)
//        is TeamStandingsUiState.Error -> TopSongsErrorScreen(currentState)
//        is TeamStandingsUiState.Loading -> TopSongsLoadingScreen(currentState)
//        is TeamStandingsUiState.Idle -> TopSongsIdleScreen(currentState)
    }
}