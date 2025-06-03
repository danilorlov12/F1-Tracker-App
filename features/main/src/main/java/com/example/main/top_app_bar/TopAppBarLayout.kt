package com.example.main.top_app_bar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier = Modifier
                        .width(32.dp)
                        .height(32.dp),
                    painter = painterResource(com.example.core.R.drawable.formula_1_logo),
                    contentDescription = null,
                    tint = Color.White
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = uiData.title,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.W700
                )
            }
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