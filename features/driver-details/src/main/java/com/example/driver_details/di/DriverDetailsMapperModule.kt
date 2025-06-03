package com.example.driver_details.di

import com.example.driver_details.domain.DriverDetailsResult
import com.example.driver_details.ui.screens.DriverDetailsUiMapper
import com.example.driver_details.ui.screens.DriverDetailsUiState
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DriverDetailsMapperModule {

    @Binds
    abstract fun provideDriverDetailsMapper(mapper: DriverDetailsUiMapper): DriverDetailsResult.Mapper<DriverDetailsUiState>
}