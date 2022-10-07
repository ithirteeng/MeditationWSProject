package com.example.meditationwsproject.data.services

import com.example.meditationwsproject.domain.model.FeelingsResponse
import com.example.meditationwsproject.domain.model.QuotesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    companion object {
        const val BASE_URL = "mskko2021.mad.hakta.pro/api"
    }

    @GET("/quotes")
    suspend fun getQuotes(): Response<QuotesResponse>

    @GET("/feelings")
    suspend fun getFeelings(): Response<FeelingsResponse>


}