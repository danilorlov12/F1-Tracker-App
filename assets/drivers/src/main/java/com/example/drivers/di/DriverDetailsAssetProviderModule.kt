package com.example.drivers.di

import com.example.drivers.DriverDetailsProvider
import com.example.drivers.DriverDetailsProviderImpl
import com.example.json_serializer.json_provider.JsonProvider
import com.example.json_serializer.serialization.Serialization
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DriverDetailsAssetProviderModule {

    @Provides
    @Singleton
    fun provideCinemaAssetProvider(
        jsonProvider: JsonProvider,
        serialization: Serialization
    ): DriverDetailsProvider {
        return DriverDetailsProviderImpl(jsonProvider, serialization)
    }
}