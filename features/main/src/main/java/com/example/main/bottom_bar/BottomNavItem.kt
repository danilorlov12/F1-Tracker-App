package com.example.main.bottom_bar

import com.example.main.R

sealed class BottomNavItem(
    val route: String,
    val iconId: Int,
    val label: String
) {
    data object Standings : BottomNavItem("standings", R.drawable.ic_cup, "Standings")
    data object RaceResults : BottomNavItem("race_results", R.drawable.ic_flag, "Results")
}