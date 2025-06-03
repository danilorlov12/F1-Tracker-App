package com.example.driver_details.data.repository

import com.example.driver_details.data.api_model.DriverDetailsApiModel

val fakeDrivers = listOf(
    DriverDetailsApiModel(
        id = 0,
        firstName = "Max",
        lastName = "Verstappen",
        imageUrl = "",
        currentTeamName = "Red Bull",
        number = 1,
        countryName = "Netherlands",
        dateOfBirth = "30.09.1997",
        numberOfRaces = 221,
        wins = 65,
        podiums = 116,
        poles = 43,
        fastestLaps = 34
    )
)