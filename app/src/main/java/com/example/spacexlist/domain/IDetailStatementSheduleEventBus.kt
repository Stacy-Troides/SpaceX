package com.example.spacexlist.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

interface IDetailStatementSheduleEventBus {

    var selectedListItemId : MutableSharedFlow<Int>

    suspend fun postLisItemId(listItemId: Int)

    fun listenLisItemId(): Flow<Int>

    fun clearListItemId()
}
