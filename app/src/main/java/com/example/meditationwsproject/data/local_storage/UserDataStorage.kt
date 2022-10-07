package com.example.meditationwsproject.data.local_storage

import com.example.meditationwsproject.domain.model.User

interface UserDataStorage {
    companion object {
        const val EMAIL_KEY = "userEMail"
        const val PASSWORD_KEY = "userPassword"
        const val EMPTINESS_CASE = "nothing was found"
    }

    fun getData(): User

    fun saveData(user: User)
}