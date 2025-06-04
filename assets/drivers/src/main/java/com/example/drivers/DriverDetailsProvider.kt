package com.example.drivers

import com.example.drivers.model.DriverDetailsAssetModel

interface DriverDetailsProvider {
    fun drivers(): List<DriverDetailsAssetModel>
    fun driverById(id: Int): DriverDetailsAssetModel?
}