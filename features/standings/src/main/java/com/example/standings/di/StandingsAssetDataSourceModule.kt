package com.example.standings.di

import com.example.drivers.DriverDetailsProvider
import com.example.race_results.RaceResultsAssetProvider
import com.example.standings.data.asset_data_source.StandingsAssetDataSource
import com.example.standings.data.asset_data_source.StandingsAssetDataSourceImpl
import com.example.teams.TeamDetailsProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StandingsAssetDataSourceModule {

    @Provides
    @Singleton
    fun provideStandingsAssetDataSource(
        raceResultsAssetProvider: RaceResultsAssetProvider,
        teamsDetailsAssetProvider: TeamDetailsProvider,
        driversDetailsAssetProvider: DriverDetailsProvider
    ): StandingsAssetDataSource {
        return StandingsAssetDataSourceImpl(
            raceResultsAssetProvider, teamsDetailsAssetProvider, driversDetailsAssetProvider
        )
    }
}