package com.example.driver_details.ui.model

data class DriverDetails(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val imageUrl: String,
    val currentTeamName: String,
    val number: Int,
    val countryName: String,
    val dateOfBirth: String,
    val numberOfRaces: Int,
    val wins: Int,
    val podiums: Int,
    val poles: Int,
    val fastestLaps: Int
)