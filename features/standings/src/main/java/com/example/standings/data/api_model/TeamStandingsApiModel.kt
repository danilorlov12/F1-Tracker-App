package com.example.standings.data.api_model

import com.google.gson.annotations.SerializedName

data class TeamStandingsApiModel(
    @SerializedName("year") val year: Int,
    @SerializedName("teams") val teams: List<TeamPointsApiModel>
)