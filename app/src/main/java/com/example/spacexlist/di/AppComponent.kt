package com.example.spacexlist.di

import com.example.spacexlist.MainActivity
import com.example.spacexlist.ui.list.HistoricalEventsFragment
import com.example.spacexlist.ui.detail.OneHistoricalEventFragment
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DomainModule::class,
        DataModule::class,
        NetworkingModule::class,
        UiModule::class]
)
interface AppComponent {
    fun inject(activity: MainActivity)

    fun inject(fragment: HistoricalEventsFragment)

    fun inject(fragment: OneHistoricalEventFragment)

}