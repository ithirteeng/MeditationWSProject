package com.example.meditationwsproject.data.repository

import com.example.meditationwsproject.data.services.NetworkService
import com.example.meditationwsproject.domain.model.QuotesResponse
import com.example.meditationwsproject.domain.repository.UserQuotesRepository
import retrofit2.Response

class UserQuotesRepositoryImpl : UserQuotesRepository {
    override suspend fun getQuotesResponse(): Response<QuotesResponse> {
        return NetworkService.apiService.getQuotes()
    }

}