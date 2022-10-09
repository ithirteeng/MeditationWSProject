package com.example.meditationwsproject.presentation.activity.splash_activity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.meditationwsproject.data.repository.UserLoginRepositoryImpl
import com.example.meditationwsproject.domain.model.UserData
import com.example.meditationwsproject.domain.usecase.GetUserDataUC
import kotlinx.coroutines.launch

class SplashActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val userLoginRepositoryImpl by lazy {
        UserLoginRepositoryImpl(application.applicationContext)
    }

    private val getUserDataUC by lazy {
        GetUserDataUC(userLoginRepositoryImpl)
    }

    private val userLiveData = MutableLiveData<UserData>()

    fun getLiveData(): MutableLiveData<UserData> {
        createUser()
        return userLiveData
    }

    private fun createUser() {
        viewModelScope.launch {
            userLiveData.value = getUserDataUC.execute()
        }
    }

    fun getUserEmail(): String {
        return getUserDataUC.execute().email
    }


}