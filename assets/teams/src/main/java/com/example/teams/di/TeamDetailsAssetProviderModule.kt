package com.example.teams.di

import com.example.json_serializer.json_provider.JsonProvider
import com.example.json_serializer.serialization.Serialization
import com.example.teams.TeamDetailsProvider
import com.example.teams.TeamDetailsProviderImpl
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
    ): TeamDetailsProvider {
        return TeamDetailsProviderImpl(jsonProvider, serialization)
    }
}