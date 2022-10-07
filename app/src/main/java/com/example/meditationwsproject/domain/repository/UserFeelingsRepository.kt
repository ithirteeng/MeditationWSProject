package com.example.meditationwsproject.domain.repository

import com.example.meditationwsproject.domain.model.FeelingsResponse
import retrofit2.Response

interface UserFeelingsRepository {
    suspend fun getFeelingsResponse(): Response<FeelingsResponse>
}