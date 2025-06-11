package com.example.driver_details.data.repository

import com.example.driver_details.data.DriverDetailsServiceAPI
import com.example.driver_details.data.asset_data_source.DriverDetailsAssetDataSource
import com.example.driver_details.domain.DriverDetailsRepository
import com.example.driver_details.domain.DriverDetailsResult
import com.example.drivers.DriverDetailsAssetProvider
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DriverDetailsRepositoryImpl @Inject constructor(
    private val serviceAPI: DriverDetailsServiceAPI,
    private val driverDetailsAssetDataSource: DriverDetailsAssetDataSource
) : DriverDetailsRepository {

    override fun loadDriverDetails(id: Int) = flow {
        emit(serviceAPI.loadDriverDetails(id.toString()))
    }.map { result ->
        if (result.isSuccessful) {
            DriverDetailsResult.Success(result.body())
        } else {
            DriverDetailsResult.Error(result.message())
        }
    }.catch {
        emit(driverDetailsAssetDataSource.driverDetails(id))
    }
}