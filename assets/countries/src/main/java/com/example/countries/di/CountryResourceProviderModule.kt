package com.example.countries.di

import com.example.countries.CountryResourceProvider
import com.example.countries.CountryResourceProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CountryResourceProviderModule {

    @Provides
    @Singleton
    fun provideCountryResourceProvider(): CountryResourceProvider {
        return CountryResourceProviderImpl()
    }
}