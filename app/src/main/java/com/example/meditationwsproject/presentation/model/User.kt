package com.example.meditationwsproject.presentation.model

import java.io.Serializable

data class User(
    val email: String,
    val nickname: String,
    val avatar: String
) : Serializable
