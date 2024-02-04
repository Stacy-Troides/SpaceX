package com.example.spacexlist.di

import com.example.spacexlist.data.repository.SpaceXDataRepositoryImpl
import com.example.spacexlist.domain.EventMapper
import com.example.spacexlist.domain.Interactor
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideInteractor(
        spaceXDataRepositoryImpl: SpaceXDataRepositoryImpl,
        eventMapper: EventMapper
    ): Interactor {
        return Interactor(spaceXDataRepositoryImpl, eventMapper)
    }

}