package com.example.races.model

import com.google.gson.annotations.SerializedName

data class RaceAssetModel(
    @SerializedName("circuitId") val circuitId: Int = 0,
    @SerializedName("grandPrixId") val grandPrixId: Int = 0,
    @SerializedName("id") val id: Int = 0,
    @SerializedName("raceDate") val raceDate: String = "",
    @SerializedName("season") val season: Int = 0
)