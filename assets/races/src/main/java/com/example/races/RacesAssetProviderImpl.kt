package com.example.races

import com.example.json_serializer.fromJsonAsset
import com.example.json_serializer.json_provider.JsonProvider
import com.example.json_serializer.serialization.Serialization
import com.example.races.model.RaceAssetModel
import javax.inject.Inject
import javax.inject.Singleton

private const val RACES = "races.json"

@Singleton
class RacesAssetProviderImpl @Inject constructor(
    private val jsonProvider: JsonProvider,
    private val serialization: Serialization
) : RacesAssetProvider {

    override fun races(): List<RaceAssetModel> {
        return fromJsonAsset(jsonProvider, serialization, RACES)
    }
}