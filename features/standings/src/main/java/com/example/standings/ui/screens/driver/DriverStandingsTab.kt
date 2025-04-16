package com.example.standings.ui.screens.driver

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.standings.ui.screens.StandingsViewModel
import com.example.standings.ui.screens.driver.views.DriverStandingsSuccessScreen

@Composable
fun DriverStandingsTab(viewModel: StandingsViewModel) {
    val state by viewModel.driverState.collectAsState()

    when (val currentState = state) {
        is DriverStandingsUiState.Success -> DriverStandingsSuccessScreen(currentState.drivers)
//        is DriverStandingsUiState.Error -> TopSongsErrorScreen(currentState)
//        is DriverStandingsUiState.Loading -> TopSongsLoadingScreen(currentState)
//        is DriverStandingsUiState.Idle -> TopSongsIdleScreen(currentState)
    }
}