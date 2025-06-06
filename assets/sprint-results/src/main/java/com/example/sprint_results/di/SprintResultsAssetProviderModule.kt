package com.example.sprint_results.di

import com.example.json_serializer.json_provider.JsonProvider
import com.example.json_serializer.serialization.Serialization
import com.example.sprint_results.SprintResultsAssetProvider
import com.example.sprint_results.SprintResultsAssetProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SprintResultsAssetProviderModule {

    @Provides
    @Singleton
    fun provideSprintResultsAssetProvider(
        jsonProvider: JsonProvider,
        serialization: Serialization
    ): SprintResultsAssetProvider {
        return SprintResultsAssetProviderImpl(jsonProvider, serialization)
    }
}