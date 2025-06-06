package com.example.sprint_results

import com.example.sprint_results.model.SprintResultAssetModel

interface SprintResultsAssetProvider {
    fun sprintResults(season: Int): List<SprintResultAssetModel>
}