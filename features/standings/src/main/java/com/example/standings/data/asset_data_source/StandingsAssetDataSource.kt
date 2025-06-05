package com.example.standings.data.asset_data_source

import com.example.standings.domain.drivers.DriverStandingsResult
import com.example.standings.domain.teams.TeamStandingsResult

interface StandingsAssetDataSource {
    fun driverStandings(season: Int): DriverStandingsResult.Asset
    fun teamStandings(season: Int): TeamStandingsResult.Asset
}