package com.example.standings.ui.screens.team

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.standings.R
import com.example.standings.ui.model.Team
import com.example.standings.ui.screens.StandingsViewModel
import kotlin.math.roundToInt

@Composable
fun TeamStandingsTab(viewModel: StandingsViewModel) {
    val state by viewModel.teamState.collectAsState()

    when (val currentState = state) {
        is TeamStandingsUiState.Success -> TopSongsSuccessScreen(currentState.teams)
//        is TeamStandingsUiState.Error -> TopSongsErrorScreen(currentState)
//        is TeamStandingsUiState.Loading -> TopSongsLoadingScreen(currentState)
//        is TeamStandingsUiState.Idle -> TopSongsIdleScreen(currentState)
    }
}

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

@Composable
fun TeamItem(team: Team) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .background(
                        color = when (team.place) {
                            1 -> Color(0xFFB80000)
                            2 -> Color(0xFFFF2E2E)
                            3 -> Color(0xFFFF7373)
                            else -> Color.Transparent
                        },
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    color = Color.White,
                    text = "${team.place}",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp
                )
            }

            Text(
                text = team.name,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            Image(
                modifier = Modifier.height(36.dp).width(36.dp),
                painter = painterResource(com.example.core.R.mipmap.aston_martin),
                contentDescription = null,
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "${team.points.roundToInt()}",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                textAlign = TextAlign.End
            )
        }
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Gray
        )
    }
}