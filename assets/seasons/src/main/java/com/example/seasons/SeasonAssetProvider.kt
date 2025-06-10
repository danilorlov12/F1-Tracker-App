package com.example.seasons

import com.example.seasons.model.SeasonAssetModel

interface SeasonAssetProvider {
    fun seasonInfoBySeason(season: Int): List<SeasonAssetModel>
}