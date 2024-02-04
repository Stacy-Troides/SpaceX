package com.example.spacexlist.ui

import com.example.spacexlist.domain.IDetailStatementSheduleEventBus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class DetailStatementSheduleEventBus : IDetailStatementSheduleEventBus {

    override var selectedListItemId = MutableSharedFlow<Int>(replay = 1)


    override suspend fun postLisItemId(listItemId: Int) {
        selectedListItemId.emit(listItemId)
    }

    override fun listenLisItemId(): Flow<Int> =
        selectedListItemId

    override fun clearListItemId() {
        selectedListItemId.resetReplayCache()
    }
}
