package com.example.circuits.model

import com.google.gson.annotations.SerializedName

data class CircuitAssetModel(
    @SerializedName("circuitName") val circuitName: String = "",
    @SerializedName("city") val city: String = "",
    @SerializedName("id") val id: Int = 0
)