package com.example.standings.data.api_model

import com.google.gson.annotations.SerializedName

data class DriverApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String
)