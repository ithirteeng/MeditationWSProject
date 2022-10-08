package com.example.meditationwsproject.domain.repository

import com.example.meditationwsproject.domain.model.User
import com.example.meditationwsproject.domain.model.UserResponse
import retrofit2.Response

interface UserLoginRepository {
    suspend fun postUserData(user: User): Response<UserResponse>
}