package com.example.standings.ui.screens.driver

import com.example.standings.ui.model.Driver

interface DriverStandingsUiState {

    object Idle : DriverStandingsUiState

    object Loading : DriverStandingsUiState

    data class Success(val drivers: List<Driver>) : DriverStandingsUiState

    data class Error(val error: String) : DriverStandingsUiState
}