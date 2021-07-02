package com.module.footballscores.network


import com.module.footballscores.model.MatchResults
import retrofit2.http.GET

interface MatchResultService {
    @GET("v3/23745f3a-5eaa-43cf-ab46-737eb273596b")
    suspend fun getMatchResultsSource1(
    ): List<MatchResults>

    @GET("v3/bc1ce3b7-6ad2-4fef-af6c-08f8865b210e")
    suspend fun getMatchResultsSource2(): List<MatchResults>
}