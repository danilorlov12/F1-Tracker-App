package com.example.sprint_results.model

import com.google.gson.annotations.SerializedName

data class SprintResultAssetModel(
    @SerializedName("driverId") val driverId: Int = 0,
    @SerializedName("driverNumber") val driverNumber: Int = 0,
    @SerializedName("id") val id: Int = 0,
    @SerializedName("laps") val laps: Int = 0,
    @SerializedName("points") val points: Double = 0.0,
    @SerializedName("position") val position: Int = 0,
    @SerializedName("shortName") val shortName: String = "",
    @SerializedName("startingGrid") val startingGrid: Int = 0,
    @SerializedName("teamId") val teamId: Int = 0,
    @SerializedName("timeRetired") val timeRetired: String = "",
    @SerializedName("trackId") val trackId: Int = 0
)