package com.example.meditationwsproject.data.local_storage

import com.example.meditationwsproject.domain.model.UserData

interface UserDataStorage {
    companion object {
        const val EMAIL_KEY = "userEMail"
        const val PASSWORD_KEY = "userPassword"
        const val EMPTINESS_CASE = "nothing was found"
    }

    fun getData(): UserData

    fun saveData(userData: UserData)
}