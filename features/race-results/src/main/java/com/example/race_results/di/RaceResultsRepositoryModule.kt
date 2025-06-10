package com.example.race_results.di

import com.example.race_results.data.RaceResultsServiceAPI
import com.example.race_results.data.asset_data_source.RaceResultsAssetDataSource
import com.example.race_results.data.repository.RaceResultsRepositoryImpl
import com.example.race_results.domain.RaceResultsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RaceResultsRepositoryModule {

    @Provides
    @Singleton
    fun provideRaceResultsRepository(
        serviceApi: RaceResultsServiceAPI,
        raceResultsAssetDataSource: RaceResultsAssetDataSource
    ): RaceResultsRepository {
        return RaceResultsRepositoryImpl(serviceApi, raceResultsAssetDataSource)
    }
}