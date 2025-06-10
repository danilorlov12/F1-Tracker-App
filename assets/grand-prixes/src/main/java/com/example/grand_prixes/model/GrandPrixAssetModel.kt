package com.example.grand_prixes.model

import com.google.gson.annotations.SerializedName

data class GrandPrixAssetModel(
    @SerializedName("grandPrixName") val grandPrixName: String = "",
    @SerializedName("id") val id: Int = 0,
    @SerializedName("countryFlagName") val countryFlagName: String = ""
)