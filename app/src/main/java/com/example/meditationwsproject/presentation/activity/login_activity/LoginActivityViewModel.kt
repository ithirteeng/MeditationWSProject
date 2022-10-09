package com.example.meditationwsproject.presentation.activity.login_activity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.meditationwsproject.R
import com.example.meditationwsproject.data.repository.UserLoginRepositoryImpl
import com.example.meditationwsproject.domain.model.UserData
import com.example.meditationwsproject.domain.usecase.PostUserDataUC
import com.example.meditationwsproject.domain.usecase.SaveUserDataUc
import com.example.meditationwsproject.domain.usecase.ValidateEmailUC
import com.example.meditationwsproject.presentation.helpers.StringGetter
import com.example.meditationwsproject.presentation.helpers.ToastHelper
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

    private val userLiveData = MutableLiveData<UserData>()

    private fun createUser() {
        if (validateEmailUC.execute(userData.email)) {
            viewModelScope.launch {
                try {
                    postUserDataUC.execute(userData)
                    userLiveData.value = userData
                    saveUserDataUc.execute(userData)
                } catch (e: NullPointerException) {
                    ToastHelper.makeToast(
                        context,
                        StringGetter.getString(context, R.string.loginErrorText)
                    )
                }
            }
        } else {
            ToastHelper.makeToast(
                context,
                StringGetter.getString(context, R.string.emailErrorText)
            )
        }
    }

    fun getLiveData(): MutableLiveData<UserData> {
        createUser()
        return userLiveData
    }

    fun createUserData(email: String, password: String) {
        userData = UserData(email, password)
    }

}