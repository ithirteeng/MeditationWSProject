package com.example.meditationwsproject.presentation.helpers

import com.example.meditationwsproject.domain.model.UserDataResponse
import com.example.meditationwsproject.presentation.model.User

object ResponseConverter {
    fun convertUserDataResponseToUser(userDataResponse: UserDataResponse): User {
        return User(
            email = userDataResponse.email,
            nickname = userDataResponse.nickName,
            avatar = userDataResponse.avatar
        )
    }
}