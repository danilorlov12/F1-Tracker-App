package com.example.race_results.ui.screens.views

import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.race_results.ui.model.RaceResults

@Composable
fun RaceResultsTabs(result: RaceResults) {
    var selectedTab by remember { mutableIntStateOf(0) }

    val tabs = listOf("Upcoming", "Finished")

    TabRow(
        modifier = Modifier,
        contentColor = Color.Black,
        selectedTabIndex = selectedTab,
        indicator = { tabPositions ->
            if (selectedTab < tabPositions.size) {
                SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                    color = Color.White,
                    height = 2.dp
                )
            }
        },
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                text = {
                    Text(
                        text = tab,
                        color = Color.White,
                        fontSize = 18.sp
                    )
                },
                selected = selectedTab == index,
                onClick = { selectedTab = index }
            )
        }
    }
    when (selectedTab) {
        0 -> RaceResultsTable(result.unfinished)
        1 -> RaceResultsTable(result.finished)
    }
}