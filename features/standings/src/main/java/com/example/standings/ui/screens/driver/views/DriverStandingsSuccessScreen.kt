package com.example.standings.ui.screens.driver.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.standings.ui.model.Driver

@Composable
fun DriverStandingsSuccessScreen(drivers: List<Driver>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(
            items = drivers,
            key = { it.id }
        ) { driver ->
            DriverItem(driver)
        }
    }
}