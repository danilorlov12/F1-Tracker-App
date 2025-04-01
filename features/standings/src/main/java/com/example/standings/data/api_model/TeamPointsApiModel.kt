package com.example.standings.data.api_model

import com.google.gson.annotations.SerializedName

data class TeamPointsApiModel(
    @SerializedName("team") val team: TeamApiModel,
    @SerializedName("drivers") val drivers: List<DriverApiModel>,
    @SerializedName("points") val points: Double,
    @SerializedName("place") val place: Int
)