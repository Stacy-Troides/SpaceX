package com.example.spacexlist.data.remote

import com.example.spacexlist.data.model.Event
import retrofit2.http.GET
import retrofit2.http.Path

interface SpaceXDataAPI {
    @GET("v3/history")
    suspend fun getAllHistoricalEvents(): List<Event>

    @GET("v3/history/{id}")
    suspend fun getOneHistoricalEvent(
        @Path("id") id: Int
    ): Event
}