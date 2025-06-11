package com.example.driver_details.di

import com.example.driver_details.data.asset_data_source.DriverDetailsAssetDataSource
import com.example.driver_details.data.asset_data_source.DriverDetailsAssetDataSourceImpl
import com.example.drivers.DriverDetailsAssetProvider
import com.example.teams.TeamDetailsAssetProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DriverDetailsAssetDataSourceModule {

    @Provides
    @Singleton
    fun provideDriverDetailsAssetDataSource(
        driverDetailsAssetProvider: DriverDetailsAssetProvider,
        teamDetailsAssetProvider: TeamDetailsAssetProvider,
    ): DriverDetailsAssetDataSource {
        return DriverDetailsAssetDataSourceImpl(driverDetailsAssetProvider, teamDetailsAssetProvider)
    }
}