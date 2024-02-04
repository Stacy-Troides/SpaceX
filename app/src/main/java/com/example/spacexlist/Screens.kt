package com.example.spacexlist

import com.example.spacexlist.ui.detail.OneHistoricalEventFragment
import com.example.spacexlist.ui.list.HistoricalEventsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun HistoricalEventsFragmentScreen() = FragmentScreen { HistoricalEventsFragment() }
    fun OneHistoricalEventFragmentScreen() = FragmentScreen { OneHistoricalEventFragment() }
}