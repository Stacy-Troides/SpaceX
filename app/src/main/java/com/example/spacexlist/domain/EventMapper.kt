package com.example.spacexlist.domain

import com.example.spacexlist.data.model.Event
import javax.inject.Inject

class EventMapper @Inject constructor() : Mapper<Event, EventItem> {
    override fun map(event: Event): EventItem {
        return EventItem(
            id = event.id,
            title = event.title,
            eventDateUtc = event.eventDateUtc,
            flightNumber = event.flightNumber,
            details = event.details
        )
    }
}
