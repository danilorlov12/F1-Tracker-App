package com.example.grand_prixes

import com.example.grand_prixes.model.GrandPrixAssetModel

interface GrandPrixesAssetProvider {
    fun grandPrixes(): List<GrandPrixAssetModel>
}