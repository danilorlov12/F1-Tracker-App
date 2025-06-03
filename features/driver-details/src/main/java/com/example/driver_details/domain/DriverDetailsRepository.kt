package com.example.driver_details.domain

import kotlinx.coroutines.flow.Flow

interface DriverDetailsRepository {
    fun loadDriverDetails(id: Int): Flow<DriverDetailsResult>
}