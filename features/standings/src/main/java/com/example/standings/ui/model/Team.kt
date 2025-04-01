package com.example.standings.ui.model

import androidx.compose.runtime.Immutable

@Immutable
data class Team(
    val id: Int,
    val name: String,
    val logoResId: Int,
    val points: Double,
    val place: Int
)