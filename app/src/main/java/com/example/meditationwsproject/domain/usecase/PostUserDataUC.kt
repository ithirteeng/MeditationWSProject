package com.example.meditationwsproject.domain.usecase

import com.example.meditationwsproject.domain.model.UserData
import com.example.meditationwsproject.domain.model.UserDataResponse
import com.example.meditationwsproject.domain.repository.UserLoginRepository

class PostUserDataUC(private val userLoginRepository: UserLoginRepository) {
    suspend fun execute(userData: UserData): UserDataResponse {
        return userLoginRepository.postUserData(userData).body()!!
    }
}