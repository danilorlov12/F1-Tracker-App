package com.example.standings.data.api_model

import com.google.gson.annotations.SerializedName

data class DriverStandingsApiModel(
    @SerializedName("year") val year: Int,
    @SerializedName("drivers") val drivers: List<DriverPointsApiModel>
)