package com.example.race_results.di

import com.example.json_serializer.json_provider.JsonProvider
import com.example.json_serializer.serialization.Serialization
import com.example.race_results.RaceResultsAssetProvider
import com.example.race_results.RaceResultsAssetProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RaceResultsAssetProviderModule {

    @Provides
    @Singleton
    fun provideRaceResultAssetProvider(
        jsonProvider: JsonProvider,
        serialization: Serialization
    ): RaceResultsAssetProvider {
        return RaceResultsAssetProviderImpl(jsonProvider, serialization)
    }
}