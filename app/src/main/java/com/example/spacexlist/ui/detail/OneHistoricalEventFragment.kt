package com.example.spacexlist.ui.detail

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

class OneHistoricalEventFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var oneHistoricalEventViewModel: OneHistoricalEventViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (context.applicationContext as App).getComponent()?.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        oneHistoricalEventViewModel = ViewModelProvider(this, viewModelFactory)
            .get(OneHistoricalEventViewModel::class.java)

        return composeView {
            setContent {
                OneHistoricalEventScreen(oneHistoricalEventViewModel)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        oneHistoricalEventViewModel.initDetail()
    }
}