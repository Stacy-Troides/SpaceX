package com.example.spacexlist.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexlist.domain.EventItem
import com.example.spacexlist.domain.IDetailStatementSheduleEventBus
import com.example.spacexlist.domain.Interactor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class OneHistoricalEventViewModel @Inject constructor(
    private var interactor: Interactor,
    private val detailStatementSheduleEventBus: IDetailStatementSheduleEventBus,
) :
    ViewModel() {

    private var _eventState = MutableStateFlow(EventItem())
    val eventState = _eventState.asStateFlow()

    fun initDetail() {
        viewModelScope.launch {
            detailStatementSheduleEventBus
                .listenLisItemId()
                .collect {
                    detailStatementSheduleEventBus.clearListItemId()
                    val eventItem = interactor.getOneHistoricalEvent(it)
                    _eventState.update { event ->
                        event.copy(
                            flightNumber = eventItem.flightNumber,
                            details = eventItem.details,
                            title = eventItem.title,
                            eventDateUtc = eventItem.eventDateUtc
                        )
                    }
                }
        }
    }
}
