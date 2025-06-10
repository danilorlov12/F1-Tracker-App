package com.example.teams.di

import com.example.json_serializer.json_provider.JsonProvider
import com.example.json_serializer.serialization.Serialization
import com.example.teams.TeamDetailsAssetProvider
import com.example.teams.TeamDetailsAssetProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TeamDetailsAssetProviderModule {

    @Provides
    @Singleton
    fun provideTeamDetailsAssetProvider(
        jsonProvider: JsonProvider,
        serialization: Serialization
    ): TeamDetailsAssetProvider {
        return TeamDetailsAssetProviderImpl(jsonProvider, serialization)
    }
}