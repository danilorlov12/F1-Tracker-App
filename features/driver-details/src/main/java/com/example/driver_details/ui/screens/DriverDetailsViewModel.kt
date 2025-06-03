package com.example.driver_details.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.driver_details.domain.DriverDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DriverDetailsViewModel @Inject constructor(
    private val driverDetailsUseCase: DriverDetailsUseCase,
    private val mapper: DriverDetailsUiMapper
) : ViewModel() {

    private val _driverDetailsState = MutableStateFlow<DriverDetailsUiState>(DriverDetailsUiState.Idle)
    val driverDetailsState = _driverDetailsState.asStateFlow()

    fun loadDriverDetails(id: Int) {
        viewModelScope.launch {
            _driverDetailsState.emit(DriverDetailsUiState.Loading)

            driverDetailsUseCase.invoke(id).collect {
                _driverDetailsState.emit(it.map(mapper))
            }
        }
    }
}