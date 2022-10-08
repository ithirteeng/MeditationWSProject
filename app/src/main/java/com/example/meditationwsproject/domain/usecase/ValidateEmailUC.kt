package com.example.meditationwsproject.domain.usecase

import com.example.meditationwsproject.domain.validator.LoginValidator

class ValidateEmailUC {
    private val loginValidator by lazy {
        LoginValidator()
    }

    fun execute(email: String): Boolean {
        return loginValidator.checkEmailValidity(email)
    }
}