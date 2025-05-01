package com.example.race_results.di

import com.example.race_results.domain.RaceResultsResult
import com.example.race_results.ui.screens.RaceResultsUiMapper
import com.example.race_results.ui.screens.RaceResultsUiState
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RaceResultsMapperModule {

    @Binds
    abstract fun provideRaceResultsMapper(mapper: RaceResultsUiMapper): RaceResultsResult.Mapper<RaceResultsUiState>

}