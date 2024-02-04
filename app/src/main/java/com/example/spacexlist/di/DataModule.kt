package com.example.spacexlist.di

import com.example.spacexlist.data.remote.SpaceXDataAPI
import com.example.spacexlist.data.repository.SpaceXDataRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideSpaceXDataRepository(spaceXDataAPI: SpaceXDataAPI): SpaceXDataRepositoryImpl {
        return SpaceXDataRepositoryImpl(spaceXDataAPI)
    }
}