package com.example.meditationwsproject.data.repository

import android.content.Context
import com.example.meditationwsproject.data.local_storage.SharedPreferencesStorage
import com.example.meditationwsproject.data.services.NetworkService
import com.example.meditationwsproject.domain.model.UserData
import com.example.meditationwsproject.domain.model.UserDataResponse
import com.example.meditationwsproject.domain.repository.UserLoginRepository
import retrofit2.Response

class UserLoginRepositoryImpl(context: Context) : UserLoginRepository {

    private val localStorage = SharedPreferencesStorage(context)

    override suspend fun postUserData(userData: UserData): Response<UserDataResponse> {
        return NetworkService.apiService.postLogin(userData)
    }

    override fun saveData(userData: UserData) {
        localStorage.saveData(userData)
    }

    override fun getData(): UserData {
        return localStorage.getData()
    }

}