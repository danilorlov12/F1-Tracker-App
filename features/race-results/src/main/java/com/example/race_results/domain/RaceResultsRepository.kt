package com.example.race_results.domain

import kotlinx.coroutines.flow.Flow

interface RaceResultsRepository {
    fun loadRaceResultsByYear(year: Int): Flow<RaceResultsResult>
}