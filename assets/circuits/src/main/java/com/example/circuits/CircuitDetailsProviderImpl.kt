package com.example.circuits

import com.example.circuits.model.CircuitAssetModel
import com.example.json_serializer.fromJsonAsset
import com.example.json_serializer.json_provider.JsonProvider
import com.example.json_serializer.serialization.Serialization
import javax.inject.Inject
import javax.inject.Singleton

private const val CIRCUITS = "circuits.json"

@Singleton
class CircuitDetailsProviderImpl @Inject constructor(
    private val jsonProvider: JsonProvider,
    private val serialization: Serialization
) : CircuitDetailsProvider {

    override fun circuits(): List<CircuitAssetModel> {
        return fromJsonAsset(jsonProvider, serialization, CIRCUITS)
    }

    override fun circuitById(id: Int): CircuitAssetModel? {
        val circuit = fromJsonAsset<List<CircuitAssetModel>>(jsonProvider, serialization, CIRCUITS)
        return circuit.find { it.id == id }
    }
}