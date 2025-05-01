package com.example.race_results.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.race_results.ui.model.RaceResults
import com.example.race_results.ui.screens.views.RaceResultsTable
import com.example.race_results.ui.screens.views.RaceResultsTabs

@Composable
fun RaceResultsScreen(
    viewModel: RaceResultsViewModel = hiltViewModel(),
    year: Int = 2024
) {

    LaunchedEffect(year) {
        viewModel.loadStandingsByYear(year)
    }

    val state by viewModel.raceResultsState.collectAsState()

    when (val currentState = state) {
        is RaceResultsUiState.Success -> RaceResultsSuccessScreen(currentState.results)
    }
}

@Composable
fun RaceResultsSuccessScreen(result: RaceResults) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        if (result.unfinished.isNotEmpty()) {
            RaceResultsTabs(result)
        } else {
            RaceResultsTable(result.finished)
        }
    }
}