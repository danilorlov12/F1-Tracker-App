package com.example.seasons

interface SeasonAssetProvider {
    fun raceIdsBySeason(season: Int): List<Int>
}