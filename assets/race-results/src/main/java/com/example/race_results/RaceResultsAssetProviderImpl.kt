package com.example.race_results

import com.example.json_serializer.fromJsonAsset
import com.example.json_serializer.json_provider.JsonProvider
import com.example.json_serializer.serialization.Serialization
import com.example.race_results.model.RaceResultAssetModel
import javax.inject.Inject
import javax.inject.Singleton

private const val RACE_RESULTS_2024 = "race-results-2024.json"

@Singleton
class RaceResultsAssetProviderImpl @Inject constructor(
    private val jsonProvider: JsonProvider,
    private val serialization: Serialization
) : RaceResultsAssetProvider {

    override fun raceResults(season: Int): List<RaceResultAssetModel> {
        return fromJsonAsset(jsonProvider, serialization, RACE_RESULTS_2024)
    }
}