package com.example.driver_details.data

import com.example.driver_details.data.api_model.DriverDetailsApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DriverDetailsServiceAPI {

    @GET("driver_details")
    suspend fun loadDriverDetails(
        @Query("id") id: String
    ): Response<DriverDetailsApiModel>
}