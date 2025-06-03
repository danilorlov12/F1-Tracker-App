package com.example.driver_details.ui.screens

import com.example.driver_details.data.api_model.DriverDetailsApiModel
import com.example.driver_details.domain.DriverDetailsResult
import com.example.driver_details.ui.model.DriverDetails
import javax.inject.Inject

class DriverDetailsUiMapper @Inject constructor() : DriverDetailsResult.Mapper<DriverDetailsUiState> {

    override fun mapSuccess(model: DriverDetailsApiModel?): DriverDetailsUiState {
        return DriverDetailsUiState.Success(
            driver = DriverDetails(
                id = model?.id ?: -1,
                firstName = model?.firstName ?: "",
                lastName = model?.lastName ?: "",
                imageUrl = model?.imageUrl ?: "",
                currentTeamName = model?.currentTeamName ?: "",
                number = model?.number ?: -1,
                countryName = model?.countryName ?: "",
                dateOfBirth = model?.dateOfBirth ?: "",
                numberOfRaces = model?.numberOfRaces ?: 0,
                wins = model?.wins ?: 0,
                poles = model?.poles ?: 0,
                podiums = model?.podiums ?: 0,
                fastestLaps = model?.fastestLaps ?: 0
            ),
        )
    }

    override fun mapError(error: String): DriverDetailsUiState {
        return DriverDetailsUiState.Error(error)
    }
}