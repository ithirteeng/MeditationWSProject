package com.example.meditationwsproject.presentation.activity.splash_activity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.meditationwsproject.data.repository.UserLoginRepositoryImpl
import com.example.meditationwsproject.domain.usecase.GetUserDataUC
import com.example.meditationwsproject.domain.usecase.PostUserDataUC
import com.example.meditationwsproject.presentation.helpers.ResponseConverter
import com.example.meditationwsproject.presentation.model.User
import kotlinx.coroutines.launch

class SplashActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val userLoginRepositoryImpl by lazy {
        UserLoginRepositoryImpl(application.applicationContext)
    }

    private val postUserDataUC by lazy {
        PostUserDataUC(userLoginRepositoryImpl)
    }

    private val getUserDataUC by lazy {
        GetUserDataUC(userLoginRepositoryImpl)
    }

    private val userLiveData = MutableLiveData<User>()

    fun getLiveData(): MutableLiveData<User> {
        createUser()
        return userLiveData
    }

    private fun createUser() {
        viewModelScope.launch {
            val responseData = postUserDataUC.execute(getUserDataUC.execute())
            userLiveData.value = ResponseConverter.convertUserDataResponseToUser(responseData)
        }
    }

    fun getUserEmail(): String {
        return getUserDataUC.execute().email
    }


}