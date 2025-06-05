package com.example.teams

import com.example.json_serializer.fromJsonAsset
import com.example.json_serializer.json_provider.JsonProvider
import com.example.json_serializer.serialization.Serialization
import com.example.teams.model.TeamDetailsAssetModel
import javax.inject.Inject
import javax.inject.Singleton

private const val TEAMS = "teams.json"

@Singleton
class TeamDetailsProviderImpl @Inject constructor(
    private val jsonProvider: JsonProvider,
    private val serialization: Serialization
) : TeamDetailsProvider {

    override fun teams(): List<TeamDetailsAssetModel> {
        return fromJsonAsset(jsonProvider, serialization, TEAMS)
    }

    override fun teamById(id: Int): TeamDetailsAssetModel? {
        val teams = fromJsonAsset<List<TeamDetailsAssetModel>>(jsonProvider, serialization, TEAMS)
        return teams.find { it.id == id }
    }
}