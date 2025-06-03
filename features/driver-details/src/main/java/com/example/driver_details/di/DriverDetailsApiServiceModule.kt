package com.example.driver_details.di

import com.example.driver_details.data.DriverDetailsServiceAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DriverDetailsApiServiceModule {

    @Provides
    @Singleton
    fun provideDriverDetailsServiceAPI(retrofit: Retrofit): DriverDetailsServiceAPI {
        return retrofit.create(DriverDetailsServiceAPI::class.java)
    }
}