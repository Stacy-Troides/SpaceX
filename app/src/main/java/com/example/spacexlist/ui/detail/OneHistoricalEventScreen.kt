package com.example.spacexlist.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spacexlist.domain.EventItem

@Composable
fun OneHistoricalEventScreen(
    viewModel: OneHistoricalEventViewModel
) {
    val state by viewModel.eventState.collectAsState()

    OneHistoricalEventItem(state)
}

@Composable
fun OneHistoricalEventItem(event: EventItem) {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .align(CenterHorizontally)
        ) {
            Box(
                modifier = Modifier
                    .padding(40.dp, 50.dp)
            ) {
                Text(
                    text = event.flightNumber.toString(),
                    fontFamily = FontFamily.SansSerif,
                    textDecoration = TextDecoration.Underline,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 50.sp
                )
            }
            Column {
                Text(
                    modifier = Modifier.padding(vertical = 40.dp),
                    text = event.title.toString(),
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
                Text(
                    text = event.eventDateUtc.toString(),
                    fontFamily = FontFamily.SansSerif,
                    color = Color.DarkGray,
                    fontSize = 14.sp
                )
            }
        }
        Text(
            modifier = Modifier.padding(20.dp),
            text = event.details.toString(),
            fontFamily = FontFamily.Serif,
            color = Color.Black,
            fontSize = 18.sp
        )
    }
}
