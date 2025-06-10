package com.example.drivers

import com.example.drivers.model.DriverDetailsAssetModel

interface DriverDetailsAssetProvider {
    fun drivers(): List<DriverDetailsAssetModel>
    fun driverById(id: Int): DriverDetailsAssetModel?
}