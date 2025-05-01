package com.example.race_results.data.repository

import com.example.race_results.data.api_model.RaceResultApiModel
import com.example.race_results.data.api_model.RaceResultsApiModel

val raceResults = RaceResultsApiModel(
    year = 2024,
    results = listOf(
        RaceResultApiModel(
            grandPrixName = "Bahrain",
            circuitName = "Bahrain International Circuit",
            countryFlagUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Flag_of_Bahrain.svg/480px-Flag_of_Bahrain.svg.png",
            date = "02.03.2024",
            round = 1,
            finished = true,
            weather = 0,
            winner = "Max Verstappen",
            winnerTeamId = 2
        ),
        RaceResultApiModel(
            grandPrixName = "Saudi Arabian",
            circuitName = "Jeddah Corniche Circuit",
            countryFlagUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/480px-Flag_of_Saudi_Arabia.svg.png",
            date = "09.03.2024",
            round = 2,
            finished = true,
            weather = 0,
            winner = "Max Verstappen",
            winnerTeamId = 2
        ),
        RaceResultApiModel(
            grandPrixName = "Australian",
            circuitName = "Albert Park Circuit",
            countryFlagUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Flag_of_Australia_%28converted%29.svg/480px-Flag_of_Australia_%28converted%29.svg.png",
            date = "24.03.2024",
            round = 3,
            finished = true,
            weather = 0,
            winner = "Carlos Sainz",
            winnerTeamId = 1
        )
    )
)