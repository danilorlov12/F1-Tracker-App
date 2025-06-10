package com.example.drivers

import com.example.drivers.model.DriverDetailsAssetModel
import com.example.json_serializer.fromJsonAsset
import com.example.json_serializer.json_provider.JsonProvider
import com.example.json_serializer.serialization.Serialization
import javax.inject.Inject
import javax.inject.Singleton

private const val DRIVERS = "drivers.json"

@Singleton
class DriverDetailsAssetProviderImpl @Inject constructor(
    private val jsonProvider: JsonProvider,
    private val serialization: Serialization
) : DriverDetailsAssetProvider {

    override fun drivers(): List<DriverDetailsAssetModel> {
        return fromJsonAsset(jsonProvider, serialization, DRIVERS)
    }

    override fun driverById(id: Int): DriverDetailsAssetModel? {
        val drivers = fromJsonAsset<List<DriverDetailsAssetModel>>(jsonProvider, serialization, DRIVERS)
        return drivers.find { it.id == id }
    }
}