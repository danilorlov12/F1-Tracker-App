package com.example.standings.data

import com.example.standings.data.api_model.DriverStandingsApiModel
import com.example.standings.data.api_model.TeamStandingsApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StandingsServiceAPI {

    @GET("standings/drivers")
    suspend fun loadDriverStandingsByYear(
        @Query("year") year: String
    ): Response<DriverStandingsApiModel>

    @GET("standings/teams")
    suspend fun loadTeamStandingsByYear(
        @Query("year") year: String
    ): Response<TeamStandingsApiModel>
}