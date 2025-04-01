package com.example.standings.data.api_model

import com.google.gson.annotations.SerializedName

data class DriverPointsApiModel(
    @SerializedName("driver") val driver: DriverApiModel,
    @SerializedName("team") val team: TeamApiModel,
    @SerializedName("points") val points: Double,
    @SerializedName("place") val place: Int
)