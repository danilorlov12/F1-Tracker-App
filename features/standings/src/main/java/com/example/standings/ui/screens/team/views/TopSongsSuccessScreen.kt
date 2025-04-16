package com.example.standings.ui.screens.team.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.standings.ui.model.Team

@Composable
fun TopSongsSuccessScreen(teams: List<Team>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(
            items = teams,
            key = { it.id }
        ) { team ->
            TeamItem(team)
        }
    }
}