package com.example.race_results.data

import com.example.race_results.data.api_model.RaceResultsApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RaceResultsServiceAPI {

    @GET("race_results")
    suspend fun loadRaceResultsByYear(
        @Query("year") year: String
    ): Response<RaceResultsApiModel>
}