package com.example.meditationwsproject.presentation.login_activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meditationwsproject.data.repository.UserLoginRepositoryImpl
import com.example.meditationwsproject.domain.model.User
import com.example.meditationwsproject.domain.usecase.PostUserDataUC
import kotlinx.coroutines.launch

class LoginActivityViewModel() : ViewModel() {

    private val userLoginRepositoryImpl by lazy {
        UserLoginRepositoryImpl()
    }

    private val postUserDataUC by lazy {
        PostUserDataUC(userLoginRepositoryImpl)
    }

    fun executeSomething(email: String, password: String) {
        viewModelScope.launch {
            postUserDataUC.execute(createUser(email, password))
        }
    }

    private fun createUser(email: String, password: String): User {
        return User(email, password)
    }
}