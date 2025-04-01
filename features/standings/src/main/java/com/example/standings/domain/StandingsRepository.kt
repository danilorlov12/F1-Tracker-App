package com.example.standings.domain

import com.example.standings.domain.drivers.DriverStandingsResult
import com.example.standings.domain.teams.TeamStandingsResult
import kotlinx.coroutines.flow.Flow

interface StandingsRepository {
    fun loadDriverStandingsByYear(year: Int): Flow<DriverStandingsResult>
    fun loadTeamStandingsByYear(year: Int): Flow<TeamStandingsResult>
}