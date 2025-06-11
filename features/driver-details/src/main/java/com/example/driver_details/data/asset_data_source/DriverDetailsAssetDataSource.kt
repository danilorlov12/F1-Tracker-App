package com.example.driver_details.data.asset_data_source

import com.example.driver_details.domain.DriverDetailsResult

interface DriverDetailsAssetDataSource {
    fun driverDetails(driverId: Int): DriverDetailsResult.Asset
}