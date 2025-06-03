package com.example.main.top_app_bar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.main.NavigationUIHandler

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarLayout(uiData: NavigationUIHandler.Data) {
    TopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Black),
        title = {
            Text(
                text = uiData.title,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.W700
            )
        },
        actions = {
            if (uiData.showYear) {
                Text(
                    modifier = Modifier.padding(end = 8.dp),
                    text = "2024",
                    textAlign = TextAlign.End,
                    fontWeight = FontWeight.W700
                )
            }
        }
    )
}