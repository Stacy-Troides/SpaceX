package com.example.spacexlist.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexlist.Screens
import com.example.spacexlist.domain.EventItem
import com.example.spacexlist.domain.IDetailStatementSheduleEventBus
import com.example.spacexlist.domain.Interactor
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class HistoricalEventsViewModel @Inject constructor(
    private var interactor: Interactor,
    private val detailStatementSheduleEventBus: IDetailStatementSheduleEventBus,
    private val router: Router
) : ViewModel() {

    private val _state = MutableStateFlow(emptyList<EventItem>())
    val state: StateFlow<List<EventItem>> = _state

    fun getHistoricalEvents() {
        viewModelScope.launch {
            val list: List<EventItem> = interactor.getEventItemList()
            _state.update {
                list
            }
        }
    }

    fun onBackPressed() {
        router.exit()
    }

    fun onItemClick(id: Int) {
        viewModelScope.launch {
            detailStatementSheduleEventBus.postLisItemId(id)
            router.navigateTo(Screens.OneHistoricalEventFragmentScreen())
        }
    }
}