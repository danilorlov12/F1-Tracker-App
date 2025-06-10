package com.example.standings.di

import com.example.drivers.DriverDetailsAssetProvider
import com.example.race_results.RaceResultsAssetProvider
import com.example.sprint_results.SprintResultsAssetProvider
import com.example.standings.data.asset_data_source.StandingsAssetDataSource
import com.example.standings.data.asset_data_source.StandingsAssetDataSourceImpl
import com.example.teams.TeamDetailsAssetProvider
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
        sprintResultsAssetProvider: SprintResultsAssetProvider,
        teamsDetailsAssetProvider: TeamDetailsAssetProvider,
        driversDetailsAssetProvider: DriverDetailsAssetProvider
    ): StandingsAssetDataSource {
        return StandingsAssetDataSourceImpl(
            raceResultsAssetProvider, sprintResultsAssetProvider, teamsDetailsAssetProvider, driversDetailsAssetProvider
        )
    }
}