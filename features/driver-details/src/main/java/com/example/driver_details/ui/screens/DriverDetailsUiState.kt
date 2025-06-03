package com.example.driver_details.ui.screens

import com.example.driver_details.ui.model.DriverDetails

interface DriverDetailsUiState {

    object Idle : DriverDetailsUiState

    object Loading : DriverDetailsUiState

    data class Success(val driver: DriverDetails) : DriverDetailsUiState

    data class Error(val error: String) : DriverDetailsUiState
}