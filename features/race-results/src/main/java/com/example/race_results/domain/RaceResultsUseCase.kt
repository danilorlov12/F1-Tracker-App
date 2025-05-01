package com.example.race_results.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RaceResultsUseCase @Inject constructor(
    private val repository: RaceResultsRepository
) {
    operator fun invoke(year: Int): Flow<RaceResultsResult> {
        return repository.loadRaceResultsByYear(year)
    }
}