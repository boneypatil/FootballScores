package com.module.footballscores.network


import com.module.footballscores.model.MatchResults
import javax.inject.Inject

class MatchResultSource @Inject constructor(private val api: MatchResultService) {

    suspend fun getMatchResultsSource1(): List<MatchResults> {
        try {
            val newsResponse = api.getMatchResultsSource1()
            return if (newsResponse.isNullOrEmpty()) {
                emptyList()
            } else {
                newsResponse
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
        return  emptyList()
    }

    suspend fun getMatchResultsSource2(): List<MatchResults> {
        try {
            val newsResponse = api.getMatchResultsSource2()
            return if (newsResponse.isNullOrEmpty()) {
                emptyList()
            } else {
                newsResponse
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
        return  emptyList()

    }
}