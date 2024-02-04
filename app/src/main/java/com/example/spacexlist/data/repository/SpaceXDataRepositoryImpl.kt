package com.example.spacexlist.data.repository

import com.example.spacexlist.data.model.Event
import com.example.spacexlist.data.remote.SpaceXDataAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SpaceXDataRepositoryImpl @Inject constructor(private val spaceXDataAPI: SpaceXDataAPI) {

    suspend fun getAllHistoricalEvents(): List<Event> =
        withContext(Dispatchers.IO) {
            return@withContext spaceXDataAPI.getAllHistoricalEvents()
        }

    suspend fun getOneHistoricalEvent(id: Int): Event =
        withContext(Dispatchers.IO) {
            return@withContext spaceXDataAPI.getOneHistoricalEvent(id = id)
        }
}
