package com.example.meditationwsproject.domain.repository

import com.example.meditationwsproject.domain.model.UserData
import com.example.meditationwsproject.domain.model.UserDataResponse
import retrofit2.Response

interface UserLoginRepository {
    suspend fun postUserData(userData: UserData): Response<UserDataResponse>
}