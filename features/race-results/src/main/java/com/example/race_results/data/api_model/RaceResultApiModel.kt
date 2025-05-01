package com.example.race_results.data.api_model

import com.google.gson.annotations.SerializedName

data class RaceResultApiModel(
    @SerializedName("grandPrixName") val grandPrixName: String,
    @SerializedName("circuitName") val circuitName: String,
    @SerializedName("countryFlagUrl") val countryFlagUrl: String,
    @SerializedName("date") val date: String,
    @SerializedName("round") val round: Int,
    @SerializedName("finished") val finished: Boolean,
    @SerializedName("weather") val weather: Int,
    @SerializedName("winner") val winner: String,
    @SerializedName("winnerTeamId") val winnerTeamId: Int
)