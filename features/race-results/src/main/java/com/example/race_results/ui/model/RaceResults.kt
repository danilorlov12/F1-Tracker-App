package com.example.race_results.ui.model

data class RaceResults(
    val finished: List<RaceResult>,
    val unfinished: List<RaceResult>
)