package com.example.race_results.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.race_results.domain.RaceResultsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RaceResultsViewModel @Inject constructor(
    private val raceResultsUseCase: RaceResultsUseCase,
    private val mapper: RaceResultsUiMapper
) : ViewModel() {

    private val _raceResultsState = MutableStateFlow<RaceResultsUiState>(RaceResultsUiState.Idle)
    val raceResultsState = _raceResultsState.asStateFlow()

    fun loadStandingsByYear(year: Int) {
        viewModelScope.launch {
            _raceResultsState.emit(RaceResultsUiState.Loading)

            raceResultsUseCase.invoke(year).collect {
                _raceResultsState.emit(it.map(mapper))
            }
        }
    }
}