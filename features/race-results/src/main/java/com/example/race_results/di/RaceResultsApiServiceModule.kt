package com.example.race_results.di

import com.example.race_results.data.RaceResultsServiceAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RaceResultsApiServiceModule {

    @Provides
    @Singleton
    fun provideRaceResultsServiceAPI(retrofit: Retrofit): RaceResultsServiceAPI {
        return retrofit.create(RaceResultsServiceAPI::class.java)
    }
}