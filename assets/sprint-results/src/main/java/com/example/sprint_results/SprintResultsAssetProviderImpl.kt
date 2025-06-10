package com.example.sprint_results

import com.example.json_serializer.fromJsonAsset
import com.example.json_serializer.json_provider.JsonProvider
import com.example.json_serializer.serialization.Serialization
import com.example.sprint_results.model.SprintResultAssetModel
import javax.inject.Inject
import javax.inject.Singleton

private const val SPRINT_RESULTS_2024 = "sprint-results-2024.json"

@Singleton
class SprintResultsAssetProviderImpl @Inject constructor(
    private val jsonProvider: JsonProvider,
    private val serialization: Serialization
) : SprintResultsAssetProvider {

    override fun sprintResults(season: Int): List<SprintResultAssetModel> {
        return fromJsonAsset(jsonProvider, serialization, SPRINT_RESULTS_2024)
    }
}