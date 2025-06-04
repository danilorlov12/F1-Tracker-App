package com.example.json_serializer.di

import android.content.Context
import com.example.json_serializer.json_provider.JsonProvider
import com.example.json_serializer.json_provider.JsonProviderImpl
import com.example.json_serializer.serialization.Serialization
import com.example.json_serializer.serialization.SerializationImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AssetJsonSerializationModule {

    @Provides
    @Singleton
    fun provideSerialization(): Serialization {
        return SerializationImpl()
    }

    @Provides
    @Singleton
    fun provideJsonProvider(@ApplicationContext context: Context): JsonProvider {
        return JsonProviderImpl(context)
    }
}