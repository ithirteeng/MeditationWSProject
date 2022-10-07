package com.example.meditationwsproject.domain.repository

import com.example.meditationwsproject.domain.model.User

interface UserAuthenticationDataRepository {
    fun getUserData(): User

    fun saveUserData(user: User)
}