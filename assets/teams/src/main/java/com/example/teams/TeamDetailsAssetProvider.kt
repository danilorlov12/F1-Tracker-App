package com.example.teams

import com.example.teams.model.TeamDetailsAssetModel

interface TeamDetailsAssetProvider {
    fun teams(): List<TeamDetailsAssetModel>
    fun teamById(id: Int): TeamDetailsAssetModel?
}