package com.example.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.main.bottom_bar.BottomNavItem
import com.example.main.bottom_bar.BottomNavigationBar
import com.example.main.top_app_bar.TopAppBarLayout

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = listOf(BottomNavItem.Standings, BottomNavItem.RaceResults)

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val uiData = NavigationUIHandler.mapToDataByRoute(currentRoute ?: "")

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBarLayout(uiData)
        },
        bottomBar = {
            if (uiData.showBottomView) {
                BottomNavigationBar(navController, items)
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.DarkGray)
        ) {
            NavigationScreen(navController)
        }
    }
}