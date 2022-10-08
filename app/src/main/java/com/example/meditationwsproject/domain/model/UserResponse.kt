package com.example.meditationwsproject.domain.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("id")
    var id: String = "",
    @SerializedName("email")
    var email: String = "",
    @SerializedName("nickName")
    var nickName: String = "",
    @SerializedName("avatar")
    var avatar: String = "",
    @SerializedName("token")
    var token: String = ""
)
