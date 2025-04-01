package com.example.standings.di

import com.example.standings.data.StandingsServiceAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StandingsApiServiceModule {

    @Provides
    @Singleton
    fun provideFootballServiceAPI(retrofit: Retrofit): StandingsServiceAPI {
        return retrofit.create(StandingsServiceAPI::class.java)
    }
}