package com.example.meditationwsproject.domain.usecase

import com.example.meditationwsproject.domain.model.QuotesResponse
import com.example.meditationwsproject.domain.repository.UserQuotesRepository

class GetQuotesUC(private val userQuotesRepository: UserQuotesRepository) {
    suspend fun execute(): QuotesResponse {
        return userQuotesRepository.getQuotesResponse().body()!!
    }
}