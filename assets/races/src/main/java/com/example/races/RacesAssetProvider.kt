package com.example.races

import com.example.races.model.RaceAssetModel

interface RacesAssetProvider {
    fun races(): List<RaceAssetModel>
}