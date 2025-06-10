package com.example.seasons.model

import com.google.gson.annotations.SerializedName

data class SeasonAssetModel(
    @SerializedName("grandPrixId") val grandPrixId: Int = 0,
    @SerializedName("raceDate") val raceDate: String = "",
    @SerializedName("raceId") val raceId: Int = 0,
    @SerializedName("season") val season: Int = 0,
    @SerializedName("sprintDate") val sprintDate: String? = null,
    @SerializedName("sprintId") val sprintId: Int? = -1,
    @SerializedName("trackId") val trackId: Int = 0
)