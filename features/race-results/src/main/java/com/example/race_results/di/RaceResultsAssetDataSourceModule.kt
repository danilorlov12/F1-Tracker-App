package com.example.race_results.di

import com.example.circuits.CircuitDetailsProvider
import com.example.drivers.DriverDetailsAssetProvider
import com.example.grand_prixes.GrandPrixesAssetProvider
import com.example.race_results.RaceResultsAssetProvider
import com.example.race_results.data.asset_data_source.RaceResultsAssetDataSource
import com.example.race_results.data.asset_data_source.RaceResultsAssetDataSourceImpl
import com.example.seasons.SeasonAssetProvider
import com.example.teams.TeamDetailsAssetProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RaceResultsAssetDataSourceModule {

    @Provides
    @Singleton
    fun provideRaceResultsAssetDataSource(
        raceResultsAssetProvider: RaceResultsAssetProvider,
        driverDetailsAssetProvider: DriverDetailsAssetProvider,
        teamDetailsAssetProvider: TeamDetailsAssetProvider,
        circuitDetailsAssetProvider: CircuitDetailsProvider,
        grandPrixesAssetProvider: GrandPrixesAssetProvider,
        seasonAssetProvider: SeasonAssetProvider
    ): RaceResultsAssetDataSource {
        return RaceResultsAssetDataSourceImpl(
            raceResultsAssetProvider, driverDetailsAssetProvider, teamDetailsAssetProvider, circuitDetailsAssetProvider, grandPrixesAssetProvider, seasonAssetProvider
        )
    }
}