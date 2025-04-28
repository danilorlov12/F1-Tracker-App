package com.example.main.bottom_bar

sealed class BottomNavItem(
    val route: String,
    val iconId: Int,
    val label: String
) {
    data object Standings : BottomNavItem("standings", com.google.android.material.R.drawable.ic_clear_black_24, "Standings")
}