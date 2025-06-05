package com.example.seasons.di

import com.example.json_serializer.json_provider.JsonProvider
import com.example.json_serializer.serialization.Serialization
import com.example.seasons.SeasonAssetProvider
import com.example.seasons.SeasonAssetProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SeasonsAssetProviderModule {

    @Provides
    @Singleton
    fun provideSeasonsAssetProvider(
        jsonProvider: JsonProvider,
        serialization: Serialization
    ): SeasonAssetProvider {
        return SeasonAssetProviderImpl(jsonProvider, serialization)
    }
}