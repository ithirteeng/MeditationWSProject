package com.example.meditationwsproject.domain.usecase

import com.example.meditationwsproject.domain.model.UserData
import com.example.meditationwsproject.domain.repository.UserLoginRepository

class SaveUserDataUc(private val userLoginRepository: UserLoginRepository) {
    fun execute(userData: UserData) {
        userLoginRepository.saveData(userData)
    }
}