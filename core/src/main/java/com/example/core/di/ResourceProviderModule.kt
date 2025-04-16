package com.example.core.di

import com.example.core.providers.TeamLogoProvider
import com.example.core.providers.TeamLogoProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ResourceProviderModule {

    @Provides
    @Singleton
    fun provideTeamLogoProvider(): TeamLogoProvider {
        return TeamLogoProviderImpl()
    }
}