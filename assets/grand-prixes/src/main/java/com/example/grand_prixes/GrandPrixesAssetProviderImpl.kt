package com.example.grand_prixes

import com.example.grand_prixes.model.GrandPrixAssetModel
import com.example.json_serializer.fromJsonAsset
import com.example.json_serializer.json_provider.JsonProvider
import com.example.json_serializer.serialization.Serialization
import javax.inject.Inject
import javax.inject.Singleton

private const val GRAND_PRIXES = "grand-prixes.json"

@Singleton
class GrandPrixesAssetProviderImpl @Inject constructor(
    private val jsonProvider: JsonProvider,
    private val serialization: Serialization
) : GrandPrixesAssetProvider {

    override fun grandPrixes(): List<GrandPrixAssetModel> {
        return fromJsonAsset(jsonProvider, serialization, GRAND_PRIXES)
    }
}