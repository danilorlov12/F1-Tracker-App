package com.example.driver_details.data.api_model

import com.google.gson.annotations.SerializedName

data class DriverDetailsApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("currentTeamName") val currentTeamName: String,
    @SerializedName("number") val number: Int,
    @SerializedName("countryName") val countryName: String,
    @SerializedName("dateOfBirth") val dateOfBirth: String,
    @SerializedName("numberOfRaces") val numberOfRaces: Int,
    @SerializedName("wins") val wins: Int,
    @SerializedName("podiums") val podiums: Int,
    @SerializedName("poles") val poles: Int,
    @SerializedName("fastestLaps") val fastestLaps: Int
)