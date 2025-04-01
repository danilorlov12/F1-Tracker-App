package com.example.standings.ui.model

import androidx.compose.runtime.Immutable

@Immutable
data class Driver(
    val id: Int,
    val name: String,
    val points: Double,
    val place: Int,
    val teamName: String
)