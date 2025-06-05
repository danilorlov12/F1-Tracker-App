package com.example.seasons.model

import com.google.gson.annotations.SerializedName

data class SeasonAssetModel(
    @SerializedName("raceIds") val raceIds: List<Int> = listOf(),
    @SerializedName("season") val season: Int = 0
)