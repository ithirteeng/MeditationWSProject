package com.example.meditationwsproject.domain.validator

class LoginValidator {
    fun checkEmailValidity(email: String): Boolean {
        return email.contains("@")
    }
}