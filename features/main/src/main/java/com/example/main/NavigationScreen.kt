package com.example.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.main.bottom_bar.BottomNavItem
import com.example.race_results.ui.screens.RaceResultsScreen
import com.example.standings.ui.screens.StandingsScreen

@Composable
fun NavigationScreen(navController: NavHostController) {
    CompositionLocalProvider(
        LocalNavController provides navController
    ) {
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Standings.route,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None }
        ) {
            composable(BottomNavItem.Standings.route) {
                StandingsScreen()
            }
            composable(BottomNavItem.RaceResults.route) {
                RaceResultsScreen()
            }
        }
    }
}