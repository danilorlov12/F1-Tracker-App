package com.example.formula1trackerapp.standing.data

import com.example.standings.domain.StandingsRepository
import com.example.standings.domain.drivers.DriverStandingsResult
import com.example.standings.domain.teams.TeamStandingsResult
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FakeStandingsRepository @Inject constructor() : StandingsRepository {

    override fun loadDriverStandingsByYear(year: Int) = flow {
        emit(DriverStandingsResult.Success(fakeDriverList))
    }

    override fun loadTeamStandingsByYear(year: Int) = flow {
        emit(TeamStandingsResult.Success(fakeTeamList))
    }
}