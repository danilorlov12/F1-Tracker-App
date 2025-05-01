package com.example.race_results.ui.screens.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.race_results.ui.model.RaceResult

@Composable
fun RaceResultsTable(result: List<RaceResult>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(
            items = result,
            key = { it.round }
        ) { driver ->
            RaceResultItem(driver)
        }
    }
}