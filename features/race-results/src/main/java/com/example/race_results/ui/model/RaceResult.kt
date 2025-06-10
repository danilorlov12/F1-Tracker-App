package com.example.race_results.ui.model

import androidx.compose.runtime.Immutable

@Immutable
data class RaceResult(
    val countryFlagUrl: String = "",
    val countryFlagResId: Int = -1,
    val circuitName: String,
    val grandPrixName: String,
    val date: String,
    val round: Int,
    val weatherLogoResId: Int,
    val winner: String,
    val winnerTeamLogoResId: Int
)