package com.example.teams.model

import com.google.gson.annotations.SerializedName

data class TeamDetailsAssetModel(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("name") val name: String = ""
)