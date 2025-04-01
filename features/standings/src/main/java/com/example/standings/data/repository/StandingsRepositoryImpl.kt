package com.example.standings.data.repository

import com.example.standings.data.StandingsServiceAPI
import com.example.standings.domain.StandingsRepository
import com.example.standings.domain.drivers.DriverStandingsResult
import com.example.standings.domain.teams.TeamStandingsResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StandingsRepositoryImpl @Inject constructor(
    private val serviceAPI: StandingsServiceAPI
) : StandingsRepository {

    override fun loadDriverStandingsByYear(year: Int) = flow {
        emit(serviceAPI.loadDriverStandingsByYear(year.toString()))
    }.map { result ->
        if (result.isSuccessful) {
            DriverStandingsResult.Success(result.body())
        } else {
            DriverStandingsResult.Error(result.message())
        }
    }.catch {
        emit(DriverStandingsResult.Error(""))
    }

    override fun loadTeamStandingsByYear(year: Int) = flow {
        emit(serviceAPI.loadTeamStandingsByYear(year.toString()))
    }.map { result ->
        if (result.isSuccessful) {
            TeamStandingsResult.Success(result.body())
        } else {
            TeamStandingsResult.Error(result.message())
        }
    }.catch {
        emit(TeamStandingsResult.Error(""))
    }
}