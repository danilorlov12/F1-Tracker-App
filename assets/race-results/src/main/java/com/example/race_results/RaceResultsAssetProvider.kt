package com.example.race_results

import com.example.race_results.model.RaceResultAssetModel

interface RaceResultsAssetProvider {
    fun raceResults(season: Int): List<RaceResultAssetModel>
}