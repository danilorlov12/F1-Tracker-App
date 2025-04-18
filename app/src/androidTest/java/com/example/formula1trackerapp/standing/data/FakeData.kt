package com.example.formula1trackerapp.standing.data

import com.example.standings.data.api_model.DriverApiModel
import com.example.standings.data.api_model.DriverPointsApiModel
import com.example.standings.data.api_model.DriverStandingsApiModel
import com.example.standings.data.api_model.TeamApiModel
import com.example.standings.data.api_model.TeamPointsApiModel
import com.example.standings.data.api_model.TeamStandingsApiModel

val fakeDriverList = DriverStandingsApiModel(
    year = 2024,
    drivers = listOf(
        DriverPointsApiModel(
            driver = DriverApiModel(id = 0, firstName = "Max", lastName = "Verstappen"),
            team = TeamApiModel(id = 0, name = "Red Bull", titleSponsor = ""),
            points = 437.0,
            place = 1
        ),
        DriverPointsApiModel(
            driver = DriverApiModel(id = 1, firstName = "Lando", lastName = "Norris"),
            team = TeamApiModel(id = 1, name = "McLaren", titleSponsor = ""),
            points = 374.0,
            place = 2
        ),
        DriverPointsApiModel(
            driver = DriverApiModel(id = 2, firstName = "Charles", lastName = "Lecler"),
            team = TeamApiModel(id = 2, name = "Ferrari", titleSponsor = ""),
            points = 356.0,
            place = 3
        ),
        DriverPointsApiModel(
            driver = DriverApiModel(id = 3, firstName = "Oscar", lastName = "Piastri"),
            team = TeamApiModel(id = 1, name = "McLaren", titleSponsor = ""),
            points = 292.0,
            place = 4
        ),
        DriverPointsApiModel(
            driver = DriverApiModel(id = 4, firstName = "Carlos", lastName = "Sainz"),
            team = TeamApiModel(id = 2, name = "Ferrari", titleSponsor = ""),
            points = 290.0,
            place = 5
        ),
        DriverPointsApiModel(
            driver = DriverApiModel(id = 5, firstName = "George", lastName = "Russell"),
            team = TeamApiModel(id = 3, name = "Mercedes", titleSponsor = ""),
            points = 245.0,
            place = 6
        ),
        DriverPointsApiModel(
            driver = DriverApiModel(id = 6, firstName = "Lewis", lastName = "Hamilton"),
            team = TeamApiModel(id = 3, name = "Mercedes", titleSponsor = ""),
            points = 223.0,
            place = 7
        ),
        DriverPointsApiModel(
            driver = DriverApiModel(id = 7, firstName = "Sergio", lastName = "Perez"),
            team = TeamApiModel(id = 0, name = "Red Bull", titleSponsor = ""),
            points = 153.0,
            place = 8
        ),
        DriverPointsApiModel(
            driver = DriverApiModel(id = 8, firstName = "Fernando", lastName = "Alonso"),
            team = TeamApiModel(id = 4, name = "Aston Martin", titleSponsor = ""),
            points = 70.0,
            place = 9
        )
    )
)

val fakeTeamList = TeamStandingsApiModel(
    teams = listOf(
        TeamPointsApiModel(
            team = TeamApiModel(id = 0, name = "McLaren", titleSponsor = ""),
            drivers = listOf(DriverApiModel(id = 1, firstName = "Lando", lastName = "Norris"), DriverApiModel(id = 3, firstName = "Oscar", lastName = "Piastri")),
            points = 666.0,
            place = 1
        )
    ),
    year = 2024
)