package com.example.standings.data.api_model

import com.google.gson.annotations.SerializedName

data class TeamApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("title_sponsor") val titleSponsor: String
)