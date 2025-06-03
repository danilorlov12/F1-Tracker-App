package com.example.driver_details.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.driver_details.R
import com.example.driver_details.ui.model.DriverDetails

@Composable
fun DriverDetailsScreen(
    driverId: Int,
    viewModel: DriverDetailsViewModel = hiltViewModel()
) {

    LaunchedEffect(driverId) {
        viewModel.loadDriverDetails(driverId)
    }

    val state by viewModel.driverDetailsState.collectAsState()

    when (val currentState = state) {
        is DriverDetailsUiState.Success -> RaceResultsSuccessScreen(currentState.driver)
    }
}

@Composable
fun RaceResultsSuccessScreen(driver: DriverDetails) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box {
                Image(
                    modifier = Modifier.size(156.dp),
                    painter = painterResource(R.mipmap.driver_image),
                    contentDescription = null
                )

                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color.Red),
                    contentAlignment = Alignment.TopStart
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "${driver.number}",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

            Text(
                modifier = Modifier.fillMaxWidth().align(Alignment.CenterVertically),
                style = LocalTextStyle.current.copy(
                    lineHeight = 32.sp
                ),
                text = "${driver.firstName}\n${driver.lastName}",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }

        TitledText(Modifier, "Current Name", driver.currentTeamName)

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            color = Color.White,
            thickness = 2.dp
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            TitledText(Modifier.weight(1f), "Date of Birth", driver.dateOfBirth)
            TitledText(Modifier.weight(1f), "Country", driver.countryName)
        }

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            color = Color.White,
            thickness = 2.dp
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            TitledText(Modifier.weight(1f), "Races", "${driver.numberOfRaces}")
            TitledText(Modifier.weight(1f), "Wins", "${driver.wins}")
            TitledText(Modifier.weight(1f), "Podiums", "${driver.podiums}")
        }

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            color = Color.White,
            thickness = 2.dp
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            TitledText(Modifier.weight(1f), "Poles", "${driver.poles}")
            TitledText(Modifier.weight(1f), "Fastest Laps", "${driver.fastestLaps}")
        }
    }
}

@Composable
fun TitledText(modifier: Modifier, title: String, subtitle: String) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = title,
            color = Color.Gray,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = subtitle,
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}