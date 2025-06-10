package com.example.race_results.data.asset_data_source

import com.example.race_results.domain.RaceResultsResult

interface RaceResultsAssetDataSource {
    fun raceResults(season: Int): RaceResultsResult.Asset
}