package com.example.standings.data.asset_data_source

import com.example.drivers.DriverDetailsProvider
import com.example.race_results.RaceResultsAssetProvider
import com.example.standings.domain.drivers.DriverStandingsResult
import com.example.standings.domain.teams.TeamStandingsResult
import com.example.teams.TeamDetailsProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StandingsAssetDataSourceImpl @Inject constructor(
    private val raceResultsAssetProvider: RaceResultsAssetProvider,
    private val teamsDetailsAssetProvider: TeamDetailsProvider,
    private val driversDetailsAssetProvider: DriverDetailsProvider
) : StandingsAssetDataSource {

    override fun driverStandings(season: Int): DriverStandingsResult.Asset {
        val raceResults = raceResultsAssetProvider.raceResults(season)
        val drivers = driversDetailsAssetProvider.drivers()
        return DriverStandingsResult.Asset(raceResults, drivers)
    }

    override fun teamStandings(season: Int): TeamStandingsResult.Asset {
        val raceResults = raceResultsAssetProvider.raceResults(season)
        val teams = teamsDetailsAssetProvider.teams()
        return TeamStandingsResult.Asset(raceResults, teams)
    }
}