package com.example.drivers.model

import com.google.gson.annotations.SerializedName

data class DriverDetailsAssetModel(
    @SerializedName("countryName") val countryName: String = "",
    @SerializedName("dateOfBirth") val dateOfBirth: String = "",
    @SerializedName("firstName") val firstName: String = "",
    @SerializedName("id") val id: Int = -1,
    @SerializedName("imageUrl") val imageUrl: String = "",
    @SerializedName("lastName") val lastName: String = "",
    @SerializedName("races") val races: Int = 0,
    @SerializedName("wins") val wins: Int = 0,
    @SerializedName("podiums") val podiums: Int = 0,
    @SerializedName("poles") val poles: Int = 0,
    @SerializedName("fastestLaps") val fastestLaps: Int = 0
)