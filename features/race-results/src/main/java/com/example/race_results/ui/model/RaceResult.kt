package com.example.race_results.ui.model

data class RaceResult(
    val countryFlagUrl: String,
    val circuitName: String,
    val grandPrixName: String,
    val date: String,
    val round: Int,
    val weatherLogoResId: Int,
    val winner: String,
    val winnerTeamLogoResId: Int
)