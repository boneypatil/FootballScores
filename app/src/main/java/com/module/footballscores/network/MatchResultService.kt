package com.module.footballscores.network


import com.module.footballscores.model.MatchResults
import retrofit2.http.GET

interface MatchResultService {
    @GET("v3/3fadb468-fcdb-4c1f-ad9c-86603aa595b2")
    suspend fun getMatchResultsSource1(
    ): List<MatchResults>

    @GET("v3/715e6823-579c-4f31-b90c-51c6bfd3b8d0")
    suspend fun getMatchResultsSource2(): List<MatchResults>
}