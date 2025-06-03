package com.example.driver_details.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.driver_details.ui.screens.DriverDetailsScreen

const val diagramRoute = "driverDetails/{id}"

fun NavController.navigateToDriverDetails(id: Int) {
    this.navigate(diagramRoute.replace("{id}", id.toString()))
}

fun NavGraphBuilder.driverDetailsScreen() {
    val arguments = listOf(navArgument("id") { type = NavType.StringType })
    composable(route = diagramRoute, arguments = arguments) {
        val id = it.arguments?.getString("id") ?: ""
        DriverDetailsScreen(id.toIntOrNull() ?: -1)
    }
}