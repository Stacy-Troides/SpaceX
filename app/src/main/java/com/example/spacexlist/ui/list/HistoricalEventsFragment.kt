package com.example.spacexlist.ui.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.spacexlist.App
import com.example.spacexlist.di.ViewModelFactory
import com.example.spacexlist.ui.composeView
import javax.inject.Inject

class HistoricalEventsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var historicalEventsViewModel: HistoricalEventsViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as App).getComponent()?.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        historicalEventsViewModel = ViewModelProvider(this, viewModelFactory)
            .get(HistoricalEventsViewModel::class.java)

        return composeView {
            setContent {
                HistoricalEventsScreen(historicalEventsViewModel)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        historicalEventsViewModel.getHistoricalEvents()
    }
}
