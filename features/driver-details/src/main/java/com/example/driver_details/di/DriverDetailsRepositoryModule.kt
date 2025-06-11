package com.example.driver_details.di

import com.example.driver_details.data.DriverDetailsServiceAPI
import com.example.driver_details.data.asset_data_source.DriverDetailsAssetDataSource
import com.example.driver_details.data.repository.DriverDetailsRepositoryImpl
import com.example.driver_details.domain.DriverDetailsRepository
import com.example.drivers.DriverDetailsAssetProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DriverDetailsRepositoryModule {

    @Provides
    @Singleton
    fun provideDriverDetailsRepository(
        serviceApi: DriverDetailsServiceAPI,
        dataSource: DriverDetailsAssetDataSource
    ): DriverDetailsRepository {
        return DriverDetailsRepositoryImpl(serviceApi, dataSource)
    }
}