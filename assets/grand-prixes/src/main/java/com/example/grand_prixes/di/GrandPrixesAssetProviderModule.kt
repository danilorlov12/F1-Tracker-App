package com.example.grand_prixes.di

import com.example.grand_prixes.GrandPrixesAssetProvider
import com.example.grand_prixes.GrandPrixesAssetProviderImpl
import com.example.json_serializer.json_provider.JsonProvider
import com.example.json_serializer.serialization.Serialization
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GrandPrixesAssetProviderModule {

    @Provides
    @Singleton
    fun provideGrandPrixesAssetProvider(
        jsonProvider: JsonProvider,
        serialization: Serialization
    ): GrandPrixesAssetProvider {
        return GrandPrixesAssetProviderImpl(jsonProvider, serialization)
    }
}