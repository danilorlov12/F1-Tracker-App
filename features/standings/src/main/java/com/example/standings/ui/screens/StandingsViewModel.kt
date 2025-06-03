package com.example.standings.ui.screens

import com.example.base.BaseViewModel
import com.example.standings.domain.drivers.DriverStandingUseCase
import com.example.standings.domain.teams.TeamStandingsUseCase
import com.example.standings.ui.screens.driver.DriverStandingsUiMapper
import com.example.standings.ui.screens.driver.DriverStandingsUiState
import com.example.standings.ui.screens.team.TeamStandingsUiMapper
import com.example.standings.ui.screens.team.TeamStandingsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val driverStandingUseCase: DriverStandingUseCase,
    private val teamStandingUseCase: TeamStandingsUseCase,
    private val driverStandingsUiMapper: DriverStandingsUiMapper,
    private val teamStandingsUiMapper: TeamStandingsUiMapper
) : BaseViewModel() {

    private val _driverState = MutableStateFlow<DriverStandingsUiState>(DriverStandingsUiState.Idle)
    val driverState = _driverState.asStateFlow()

    private val _teamState = MutableStateFlow<TeamStandingsUiState>(TeamStandingsUiState.Idle)
    val teamState = _teamState.asStateFlow()

    private var loadedYear: Int? = null

    fun loadStandingsByYear(year: Int) {
        if (loadedYear != year) {
            launchMultipleWithCancel(
                loadingStates = listOf(
                    Pair(_driverState, DriverStandingsUiState.Loading),
                    Pair(_teamState, TeamStandingsUiState.Loading)
                )
            ) {
                val driverStandingsDeferred = async {
                    driverStandingUseCase.invoke(year).collect {
                        _driverState.emit(it.map(driverStandingsUiMapper))
                    }
                }

                val teamStandingsDeferred = async {
                    teamStandingUseCase.invoke(year).collect {
                        _teamState.emit(it.map(teamStandingsUiMapper))
                    }
                }

                driverStandingsDeferred.await()
                teamStandingsDeferred.await()

                loadedYear = year
            }
        }
    }
}