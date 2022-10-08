package com.example.meditationwsproject.data.repository

import com.example.meditationwsproject.data.services.NetworkService
import com.example.meditationwsproject.domain.model.User
import com.example.meditationwsproject.domain.model.UserResponse
import com.example.meditationwsproject.domain.repository.UserLoginRepository
import retrofit2.Response

class UserLoginRepositoryImpl : UserLoginRepository {
    override suspend fun postUserData(user: User): Response<UserResponse> {
        return NetworkService.apiService.postLogin(user)
    }

}