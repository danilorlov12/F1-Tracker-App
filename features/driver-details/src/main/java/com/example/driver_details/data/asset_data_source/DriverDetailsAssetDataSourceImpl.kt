package com.example.driver_details.data.asset_data_source

import com.example.driver_details.domain.DriverDetailsResult
import com.example.drivers.DriverDetailsAssetProvider
import com.example.teams.TeamDetailsAssetProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DriverDetailsAssetDataSourceImpl @Inject constructor(
    private val driverDetailsAssetProvider: DriverDetailsAssetProvider,
    private val teamDetailsAssetProvider: TeamDetailsAssetProvider
) : DriverDetailsAssetDataSource {

    override fun driverDetails(driverId: Int): DriverDetailsResult.Asset {
        val drivers = driverDetailsAssetProvider.driverById(driverId)
        val teams = teamDetailsAssetProvider.teams()
        return DriverDetailsResult.Asset(drivers, teams)
    }
}