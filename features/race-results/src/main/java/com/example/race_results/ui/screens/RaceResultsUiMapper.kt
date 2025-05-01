package com.example.race_results.ui.screens

import com.example.core.providers.TeamLogoProvider
import com.example.race_results.data.api_model.RaceResultApiModel
import com.example.race_results.data.api_model.RaceResultsApiModel
import com.example.race_results.domain.RaceResultsResult
import com.example.race_results.ui.model.RaceResult
import com.example.race_results.ui.model.RaceResults
import javax.inject.Inject

class RaceResultsUiMapper @Inject constructor(
    private val teamLogoProvider: TeamLogoProvider
) : RaceResultsResult.Mapper<RaceResultsUiState> {

    override fun mapSuccess(model: RaceResultsApiModel?): RaceResultsUiState {
        return RaceResultsUiState.Success(
            results = RaceResults(
                finished = model?.results?.filter { it.finished }?.map { mapToRaceResult(it) } ?: emptyList(),
                unfinished = model?.results?.filter { !it.finished }?.map { mapToRaceResult(it) } ?: emptyList()
            )
        )
    }

    private fun mapToRaceResult(result: RaceResultApiModel) = RaceResult(
        countryFlagUrl = result.countryFlagUrl,
        circuitName = result.circuitName,
        grandPrixName = result.grandPrixName,
        date = result.date,
        round = result.round,
        weatherLogoResId = result.weather,
        winner = result.winner,
        winnerTeamLogoResId = teamLogoProvider.logoByTeamId(result.winnerTeamId)
    )

    override fun mapError(error: String): RaceResultsUiState {
        return RaceResultsUiState.Error(error)
    }
}