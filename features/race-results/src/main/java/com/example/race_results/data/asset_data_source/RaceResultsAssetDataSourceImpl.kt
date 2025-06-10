package com.example.race_results.data.asset_data_source

import com.example.circuits.CircuitDetailsProvider
import com.example.drivers.DriverDetailsAssetProvider
import com.example.grand_prixes.GrandPrixesAssetProvider
import com.example.race_results.RaceResultsAssetProvider
import com.example.race_results.domain.RaceResultsResult
import com.example.seasons.SeasonAssetProvider
import com.example.teams.TeamDetailsAssetProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RaceResultsAssetDataSourceImpl @Inject constructor(
    private val raceResultsAssetProvider: RaceResultsAssetProvider,
    private val driverDetailsAssetProvider: DriverDetailsAssetProvider,
    private val teamDetailsAssetProvider: TeamDetailsAssetProvider,
    private val circuitDetailsAssetProvider: CircuitDetailsProvider,
    private val grandPrixesAssetProvider: GrandPrixesAssetProvider,
    private val seasonAssetProvider: SeasonAssetProvider
) : RaceResultsAssetDataSource {

    override fun raceResults(season: Int): RaceResultsResult.Asset {
        val raceResults = raceResultsAssetProvider.raceResults(season)
        val drivers = driverDetailsAssetProvider.drivers()
        val teams = teamDetailsAssetProvider.teams()
        val circuits = circuitDetailsAssetProvider.circuits()
        val grandPrixes = grandPrixesAssetProvider.grandPrixes()
        val seasons = seasonAssetProvider.seasonInfoBySeason(season)

        return RaceResultsResult.Asset(raceResults, drivers, teams, circuits, grandPrixes, seasons)
    }
}