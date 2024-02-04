package com.example.spacexlist.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spacexlist.domain.EventItem

@Composable
fun HistoricalEventsScreen(
    viewModel: HistoricalEventsViewModel
) {
    val state by viewModel.state.collectAsState()

    LazyColumn {
        items(state) { eventItem ->
            HistoricalEventItem(eventItem = eventItem,
                onItemClick = { id -> viewModel.onItemClick(id) })
        }
    }
}

@Composable
fun HistoricalEventItem(eventItem: EventItem, onItemClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .height(100.dp)
            .clickable { onItemClick(eventItem.id)},
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(6.dp)

        ) {
            Row {
                Box(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = eventItem.title.toString(),
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
                Text(
                    text = eventItem.flightNumber.toString(),
                    color = Color.Black,
                )
            }
            Text(
                text = eventItem.details.toString(),
                color = Color.Black,
                fontSize = 16.sp,
                maxLines = 2
            )
            Text(
                text = eventItem.eventDateUtc.toString(),
                color = Color.DarkGray,
                fontSize = 12.sp
            )
        }
    }
}