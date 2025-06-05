package com.example.teams

import com.example.teams.model.TeamDetailsAssetModel

interface TeamDetailsProvider {
    fun teams(): List<TeamDetailsAssetModel>
    fun teamById(id: Int): TeamDetailsAssetModel?
}