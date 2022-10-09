package com.example.meditationwsproject.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserData(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
): Serializable
