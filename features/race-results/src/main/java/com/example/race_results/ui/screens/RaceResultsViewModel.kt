package com.example.race_results.ui.screens

import com.example.base.BaseViewModel
import com.example.race_results.domain.RaceResultsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RaceResultsViewModel @Inject constructor(
    private val raceResultsUseCase: RaceResultsUseCase,
    private val mapper: RaceResultsUiMapper
) : BaseViewModel() {

    private val _raceResultsState = MutableStateFlow<RaceResultsUiState>(RaceResultsUiState.Idle)
    val raceResultsState = _raceResultsState.asStateFlow()

    private var loadedYear: Int? = null

    fun loadStandingsByYear(year: Int) {
        if (loadedYear != year) {
            launchWithCancel(_raceResultsState, RaceResultsUiState.Loading) {
                raceResultsUseCase.invoke(year).collect {
                    _raceResultsState.emit(it.map(mapper))
                }
                loadedYear = year
            }
        }
    }
}