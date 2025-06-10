package com.example.standings.di

import com.example.standings.data.StandingsServiceAPI
import com.example.standings.data.asset_data_source.StandingsAssetDataSource
import com.example.standings.data.repository.StandingsRepositoryImpl
import com.example.standings.domain.StandingsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StandingsRepositoryModule {

    @Provides
    @Singleton
    fun provideStandingsRepository(
        serviceApi: StandingsServiceAPI,
        dataSource: StandingsAssetDataSource
    ): StandingsRepository {
        return StandingsRepositoryImpl(serviceApi, dataSource)
    }
}