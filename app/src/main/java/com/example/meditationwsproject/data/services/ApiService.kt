package com.example.meditationwsproject.data.services

import com.example.meditationwsproject.domain.model.FeelingsResponse
import com.example.meditationwsproject.domain.model.QuotesResponse
import com.example.meditationwsproject.domain.model.UserData
import com.example.meditationwsproject.domain.model.UserDataResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    companion object {
        const val BASE_URL = "http://mskko2021.mad.hakta.pro/api/"

    }

    @GET("quotes")
    suspend fun getQuotes(): Response<QuotesResponse>

    @GET("feelings")
    suspend fun getFeelings(): Response<FeelingsResponse>

    @POST("user/login")
    suspend fun postLogin(@Body userData: UserData): Response<UserDataResponse>


}