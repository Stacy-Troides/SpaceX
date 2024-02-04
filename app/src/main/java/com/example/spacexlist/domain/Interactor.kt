package com.example.spacexlist.domain

import com.example.spacexlist.data.model.Event
import com.example.spacexlist.data.repository.SpaceXDataRepositoryImpl
import javax.inject.Inject

class Interactor @Inject constructor(
    private val spaceXDataRepositoryImpl: SpaceXDataRepositoryImpl,
    private val eventMapper: EventMapper
) {

    suspend fun getEventItemList(): List<EventItem> {
        return spaceXDataRepositoryImpl.getAllHistoricalEvents().map { eventMapper.map(it) }
    }

    suspend fun getOneHistoricalEvent(id: Int): Event {
        return spaceXDataRepositoryImpl.getOneHistoricalEvent(id)
    }
}