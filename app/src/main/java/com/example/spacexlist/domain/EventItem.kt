package com.example.spacexlist.domain

import com.squareup.moshi.Json

data class EventItem(
    val id: Int = 0,
    val title: String? = String(),
    @Json(name = "event_date_utc")
    val eventDateUtc: String? = String(),
    @Json(name = "flight_number")
    val flightNumber: Int? = 0,
    val details: String? = String()
)


