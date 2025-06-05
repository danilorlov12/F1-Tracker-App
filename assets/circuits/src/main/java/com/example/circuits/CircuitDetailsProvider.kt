package com.example.circuits

import com.example.circuits.model.CircuitAssetModel

interface CircuitDetailsProvider {
    fun circuits(): List<CircuitAssetModel>
    fun circuitById(id: Int): CircuitAssetModel?
}