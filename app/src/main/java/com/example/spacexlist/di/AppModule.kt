package com.example.spacexlist.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.spacexlist.ui.list.HistoricalEventsViewModel
import com.example.spacexlist.ui.detail.OneHistoricalEventViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppModule {

    @Binds
    @IntoMap
    @ViewModelKey(HistoricalEventsViewModel::class)
    abstract fun bindHistoricalViewModel(mainViewModel: HistoricalEventsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(OneHistoricalEventViewModel::class)
    abstract fun bindOneHistoricalViewModel(mainViewModel: OneHistoricalEventViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory):
            ViewModelProvider.Factory
}