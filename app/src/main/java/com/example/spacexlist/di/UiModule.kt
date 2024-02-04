package com.example.spacexlist.di

import com.example.spacexlist.domain.IDetailStatementSheduleEventBus
import com.example.spacexlist.ui.DetailStatementSheduleEventBus
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UiModule {

    @Singleton
    @Provides
    fun provideEventBus(): IDetailStatementSheduleEventBus {
        return DetailStatementSheduleEventBus()
    }

    private val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    fun provideRouter(): Router = cicerone.router

    @Singleton
    @Provides
    fun provideNavigatorHolder(): NavigatorHolder = cicerone.getNavigatorHolder()

}