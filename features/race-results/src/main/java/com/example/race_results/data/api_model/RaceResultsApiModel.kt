package com.example.race_results.data.api_model

import com.google.gson.annotations.SerializedName

data class RaceResultsApiModel(
    @SerializedName("year") val year: Int,
    @SerializedName("race_results") val results: List<RaceResultApiModel>
)