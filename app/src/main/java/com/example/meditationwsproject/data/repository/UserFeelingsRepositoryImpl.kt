package com.example.meditationwsproject.data.repository

import com.example.meditationwsproject.data.services.NetworkService
import com.example.meditationwsproject.domain.model.FeelingsResponse
import com.example.meditationwsproject.domain.repository.UserFeelingsRepository
import retrofit2.Response

class UserFeelingsRepositoryImpl : UserFeelingsRepository {
    override suspend fun getFeelingsResponse(): Response<FeelingsResponse> {
        return NetworkService.apiService.getFeelings()
    }

}