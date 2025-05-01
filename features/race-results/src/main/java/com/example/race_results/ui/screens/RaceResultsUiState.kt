package com.example.race_results.ui.screens

import com.example.race_results.ui.model.RaceResults

interface RaceResultsUiState {

    object Idle : RaceResultsUiState

    object Loading : RaceResultsUiState

    data class Success(val results: RaceResults) : RaceResultsUiState

    data class Error(val error: String) : RaceResultsUiState
}