package com.example.circuits.di

import com.example.circuits.CircuitDetailsProvider
import com.example.circuits.CircuitDetailsProviderImpl
import com.example.json_serializer.json_provider.JsonProvider
import com.example.json_serializer.serialization.Serialization
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CircuitDetailsAssetProviderModule {

    @Provides
    @Singleton
    fun provideCircuitDetailsAssetProvider(
        jsonProvider: JsonProvider,
        serialization: Serialization
    ): CircuitDetailsProvider {
        return CircuitDetailsProviderImpl(jsonProvider, serialization)
    }
}