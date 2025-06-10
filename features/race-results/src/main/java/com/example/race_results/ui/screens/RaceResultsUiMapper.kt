package com.example.race_results.ui.screens

import com.example.circuits.model.CircuitAssetModel
import com.example.core.providers.TeamLogoProvider
import com.example.countries.CountryResourceProvider
import com.example.drivers.model.DriverDetailsAssetModel
import com.example.grand_prixes.model.GrandPrixAssetModel
import com.example.race_results.data.api_model.RaceResultApiModel
import com.example.race_results.data.api_model.RaceResultsApiModel
import com.example.race_results.domain.RaceResultsResult
import com.example.race_results.model.RaceResultAssetModel
import com.example.race_results.ui.model.RaceResult
import com.example.race_results.ui.model.RaceResults
import com.example.seasons.model.SeasonAssetModel
import com.example.teams.model.TeamDetailsAssetModel
import javax.inject.Inject

class RaceResultsUiMapper @Inject constructor(
    private val teamLogoProvider: TeamLogoProvider,
    private val countryResourceProvider: CountryResourceProvider
) : RaceResultsResult.Mapper<RaceResultsUiState> {

    override fun mapSuccess(model: RaceResultsApiModel?): RaceResultsUiState {
        return RaceResultsUiState.Success(
            RaceResults(
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

    override fun mapAsset(
        raceResults: List<RaceResultAssetModel>,
        drivers: List<DriverDetailsAssetModel>,
        teams: List<TeamDetailsAssetModel>,
        circuits: List<CircuitAssetModel>,
        grandPrixes: List<GrandPrixAssetModel>,
        seasons: List<SeasonAssetModel>
    ): RaceResultsUiState {

        val finishedGrandPrixes = seasons.mapIndexed { index, season ->
            val winner = raceResults.filter { it.id == season.raceId }.first { it.position == 1 }
            val countryFlagName = grandPrixes.first { it.id == season.grandPrixId }.countryFlagName
            RaceResult(
                countryFlagResId = countryResourceProvider.countryFlagResByName(countryFlagName),
                circuitName = circuits.first { it.id == season.trackId }.circuitName,
                grandPrixName = grandPrixes.first { it.id == season.grandPrixId }.grandPrixName,
                date = season.raceDate,
                round = index + 1,
                weatherLogoResId = 0,
                winner = run {
                    drivers.first { it.id == winner.driverId }.lastName
                },
                winnerTeamLogoResId = run {
                    val team = teams.first { it.id == winner.teamId }
                    teamLogoProvider.logoByTeamId(team.id)
                }
            )
        }

        return RaceResultsUiState.Success(
            RaceResults(
                finished = finishedGrandPrixes,
                unfinished = emptyList()
            )
        )
    }
}