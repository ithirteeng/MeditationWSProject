package com.example.meditationwsproject.presentation.activity.login_activity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.meditationwsproject.R
import com.example.meditationwsproject.data.repository.UserLoginRepositoryImpl
import com.example.meditationwsproject.domain.model.UserData
import com.example.meditationwsproject.domain.model.UserDataResponse
import com.example.meditationwsproject.domain.usecase.PostUserDataUC
import com.example.meditationwsproject.domain.usecase.SaveUserDataUc
import com.example.meditationwsproject.domain.usecase.ValidateEmailUC
import com.example.meditationwsproject.presentation.helpers.StringGetter
import com.example.meditationwsproject.presentation.helpers.ToastHelper
import com.example.meditationwsproject.presentation.model.User
import kotlinx.coroutines.launch

class LoginActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val context by lazy {
        application.applicationContext
    }

    private val userLoginRepositoryImpl by lazy {
        UserLoginRepositoryImpl(context)
    }

    private val validateEmailUC by lazy {
        ValidateEmailUC()
    }

    private val postUserDataUC by lazy {
        PostUserDataUC(userLoginRepositoryImpl)
    }

    private val saveUserDataUc by lazy {
        SaveUserDataUc(userLoginRepositoryImpl)
    }

    private lateinit var userData: UserData

    private val userLiveData = MutableLiveData<User>()

    private fun createUser() {
        if (validateEmailUC.execute(userData.email)) {
            viewModelScope.launch {
                val responseData = postUserDataUC.execute(userData)
                userLiveData.value = responseDataToUser(responseData)
                saveUserDataUc.execute(userData)
            }
        } else {
            ToastHelper.makeToast(
                context,
                StringGetter.getString(context, R.string.emailErrorText)
            )
        }
    }

    fun getLiveData(): MutableLiveData<User> {
            try {
                createUser()
            } catch (e: Exception) {
                ToastHelper.makeToast(
                    context,
                    StringGetter.getString(context, R.string.loginErrorText)
                )
            }
        return userLiveData
    }

    fun createUserData(email: String, password: String) {
        userData = UserData(email, password)
    }


    private fun responseDataToUser(userDataResponse: UserDataResponse): User {
        return User(
            email = userDataResponse.email,
            nickname = userDataResponse.nickName,
            avatar = userDataResponse.avatar
        )
    }


}