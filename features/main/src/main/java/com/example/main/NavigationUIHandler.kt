package com.example.main

import com.example.main.bottom_bar.BottomNavItem

object NavigationUIHandler {

    fun mapToDataByRoute(route: String): Data {
        val title = when {
            route.contains("driverDetails") -> "Driver Details"
            route == BottomNavItem.Standings.route -> BottomNavItem.Standings.label
            route == BottomNavItem.RaceResults.route -> BottomNavItem.RaceResults.label
            else -> "F1 Tracker App"
        }

        val showBottomView = !route.contains("/")
        val showYear = !route.contains("/")

        return Data(title, showYear, showBottomView)
    }

    data class Data(
        val title: String,
        val showYear: Boolean,
        val showBottomView: Boolean
    )
}