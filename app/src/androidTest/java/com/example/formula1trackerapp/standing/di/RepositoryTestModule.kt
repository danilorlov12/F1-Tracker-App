package com.example.formula1trackerapp.standing.di

import com.example.formula1trackerapp.standing.data.FakeStandingsRepository
import com.example.standings.di.StandingsRepositoryModule
import com.example.standings.domain.StandingsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [StandingsRepositoryModule::class]
)
object RepositoryTestModule {

    @Provides
    @Singleton
    fun provideFakeStandingsRepository(): StandingsRepository {
        return FakeStandingsRepository()
    }
}