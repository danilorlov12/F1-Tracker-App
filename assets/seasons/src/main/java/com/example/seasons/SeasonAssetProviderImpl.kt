package com.example.seasons

import com.example.json_serializer.fromJsonAsset
import com.example.json_serializer.json_provider.JsonProvider
import com.example.json_serializer.serialization.Serialization
import com.example.seasons.model.SeasonAssetModel
import javax.inject.Inject
import javax.inject.Singleton

private const val SEASONS = "seasons.json"

@Singleton
class SeasonAssetProviderImpl @Inject constructor(
    private val jsonProvider: JsonProvider,
    private val serialization: Serialization
) : SeasonAssetProvider {

    override fun raceIdsBySeason(season: Int): List<Int> {
        val seasons = fromJsonAsset<List<SeasonAssetModel>>(jsonProvider, serialization, SEASONS)
        return seasons.find { it.season == season }?.raceIds ?: emptyList()
    }
}