package com.example.driver_details.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DriverDetailsUseCase @Inject constructor(
    private val repository: DriverDetailsRepository
) {
    operator fun invoke(id: Int): Flow<DriverDetailsResult> {
        return repository.loadDriverDetails(id)
    }
}