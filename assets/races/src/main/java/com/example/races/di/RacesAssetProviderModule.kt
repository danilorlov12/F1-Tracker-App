package com.example.races.di

import com.example.json_serializer.json_provider.JsonProvider
import com.example.json_serializer.serialization.Serialization
import com.example.races.RacesAssetProvider
import com.example.races.RacesAssetProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RacesAssetProviderModule {

    @Provides
    @Singleton
    fun provideRacesAssetProvider(
        jsonProvider: JsonProvider,
        serialization: Serialization
    ): RacesAssetProvider {
        return RacesAssetProviderImpl(jsonProvider, serialization)
    }
}