package com.example.meditationwsproject.presentation.activity.login_activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meditationwsproject.data.repository.UserLoginRepositoryImpl
import com.example.meditationwsproject.domain.model.UserData
import com.example.meditationwsproject.domain.model.UserDataResponse
import com.example.meditationwsproject.domain.usecase.PostUserDataUC
import com.example.meditationwsproject.presentation.model.User
import kotlinx.coroutines.launch

class LoginActivityViewModel : ViewModel() {

    private val userLoginRepositoryImpl by lazy {
        UserLoginRepositoryImpl()
    }

    private val postUserDataUC by lazy {
        PostUserDataUC(userLoginRepositoryImpl)
    }

    fun executeSomething(email: String, password: String): User {
        var user: User? = null
        viewModelScope.launch {
            val responseData = postUserDataUC.execute(createUser(email, password))
            user = responseDataToUser(responseData)
        }
        return user!!
    }

    private fun responseDataToUser(userDataResponse: UserDataResponse): User {
        return User(
            email = userDataResponse.email,
            nickname = userDataResponse.nickName,
            avatar = userDataResponse.avatar
        )
    }

    private fun createUser(email: String, password: String): UserData {
        return UserData(email, password)
    }
}