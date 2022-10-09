package com.example.meditationwsproject.domain.usecase

import com.example.meditationwsproject.domain.model.FeelingsResponse
import com.example.meditationwsproject.domain.repository.UserFeelingsRepository

class GetFeelingsUC(private val userFeelingsRepository: UserFeelingsRepository) {
    suspend fun execute(): FeelingsResponse {
        return userFeelingsRepository.getFeelingsResponse().body()!!
    }
}