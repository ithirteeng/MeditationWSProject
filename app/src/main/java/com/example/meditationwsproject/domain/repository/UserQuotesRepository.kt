package com.example.meditationwsproject.domain.repository

import com.example.meditationwsproject.domain.model.QuotesResponse
import retrofit2.Response

interface UserQuotesRepository {
    suspend fun getQuotesResponse(): Response<QuotesResponse>
}