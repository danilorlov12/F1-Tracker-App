package com.example.standings.domain.drivers

import com.example.standings.domain.StandingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DriverStandingUseCase @Inject constructor(
    private val repository: StandingsRepository
) {
    operator fun invoke(year: Int): Flow<DriverStandingsResult> {
        return repository.loadDriverStandingsByYear(year)
    }
}