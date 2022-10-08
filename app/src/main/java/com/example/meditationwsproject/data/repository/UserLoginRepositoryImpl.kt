package com.example.meditationwsproject.data.repository

import com.example.meditationwsproject.data.services.NetworkService
import com.example.meditationwsproject.domain.model.UserData
import com.example.meditationwsproject.domain.model.UserDataResponse
import com.example.meditationwsproject.domain.repository.UserLoginRepository
import retrofit2.Response

class UserLoginRepositoryImpl : UserLoginRepository {
    override suspend fun postUserData(userData: UserData): Response<UserDataResponse> {
        return NetworkService.apiService.postLogin(userData)
    }

}