package com.example.meditationwsproject.domain.usecase

import com.example.meditationwsproject.domain.model.UserData
import com.example.meditationwsproject.domain.repository.UserLoginRepository

class GetUserDataUC(private val userLoginRepository: UserLoginRepository) {
    fun execute(): UserData {
        return userLoginRepository.getData()
    }
}