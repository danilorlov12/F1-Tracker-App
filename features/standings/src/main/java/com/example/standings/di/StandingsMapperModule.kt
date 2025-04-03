package com.example.standings.di

import com.example.standings.domain.drivers.DriverStandingsResult
import com.example.standings.domain.teams.TeamStandingsResult
import com.example.standings.ui.screens.driver.DriverStandingsUiMapper
import com.example.standings.ui.screens.driver.DriverStandingsUiState
import com.example.standings.ui.screens.team.TeamStandingsUiMapper
import com.example.standings.ui.screens.team.TeamStandingsUiState
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StandingsMapperModule {

    @Binds
    abstract fun provideDriverStandingsMapper(mapper: DriverStandingsUiMapper): DriverStandingsResult.Mapper<DriverStandingsUiState>

    @Binds
    abstract fun provideTeamStandingsMapper(mapper: TeamStandingsUiMapper): TeamStandingsResult.Mapper<TeamStandingsUiState>

}