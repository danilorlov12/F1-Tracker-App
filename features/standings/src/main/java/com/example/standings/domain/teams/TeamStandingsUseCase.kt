package com.example.standings.domain.teams

import com.example.standings.domain.StandingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TeamStandingsUseCase @Inject constructor(
    private val repository: StandingsRepository
) {
    operator fun invoke(year: Int): Flow<TeamStandingsResult> {
        return repository.loadTeamStandingsByYear(year)
    }
}