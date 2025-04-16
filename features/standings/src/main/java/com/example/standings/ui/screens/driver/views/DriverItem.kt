package com.example.standings.ui.screens.driver.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.standings.ui.model.Driver
import kotlin.math.roundToInt

@Composable
fun DriverItem(driver: Driver) {
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
                        color = when (driver.place) {
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
                    text = "${driver.place}",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp
                )
            }

            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = driver.name,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Text(
                    text = driver.teamName,
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )
            }

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "${driver.points.roundToInt()}",
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