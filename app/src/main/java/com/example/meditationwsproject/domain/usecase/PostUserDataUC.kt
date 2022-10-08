package com.example.meditationwsproject.domain.usecase

import com.example.meditationwsproject.domain.model.User
import com.example.meditationwsproject.domain.model.UserResponse
import com.example.meditationwsproject.domain.repository.UserLoginRepository

class PostUserDataUC(private val userLoginRepository: UserLoginRepository) {
    suspend fun execute(user: User): UserResponse {
        return userLoginRepository.postUserData(user).body()!!
    }
}