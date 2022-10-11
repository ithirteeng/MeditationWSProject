package com.example.meditationwsproject.presentation.activity.main_activity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.meditationwsproject.R
import com.example.meditationwsproject.data.repository.UserFeelingsRepositoryImpl
import com.example.meditationwsproject.data.repository.UserLoginRepositoryImpl
import com.example.meditationwsproject.data.repository.UserQuotesRepositoryImpl
import com.example.meditationwsproject.domain.model.Feeling
import com.example.meditationwsproject.domain.model.Quote
import com.example.meditationwsproject.domain.model.UserData
import com.example.meditationwsproject.domain.usecase.GetFeelingsUC
import com.example.meditationwsproject.domain.usecase.GetQuotesUC
import com.example.meditationwsproject.domain.usecase.PostUserDataUC
import com.example.meditationwsproject.presentation.helpers.ResponseConverter
import com.example.meditationwsproject.presentation.helpers.StringGetter
import com.example.meditationwsproject.presentation.helpers.ToastHelper
import com.example.meditationwsproject.presentation.model.User
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val context by lazy {
        application.applicationContext
    }

    private val userLoginRepositoryImpl by lazy {
        UserLoginRepositoryImpl(application.applicationContext)
    }

    private val userFeelingsRepositoryImpl by lazy {
        UserFeelingsRepositoryImpl()
    }

    private val userQuotesRepositoryImpl by lazy {
        UserQuotesRepositoryImpl()
    }

    private val postUserDataUC by lazy {
        PostUserDataUC(userLoginRepositoryImpl)
    }

    private val getQuotesUC by lazy {
        GetQuotesUC(userQuotesRepositoryImpl)
    }

    private val getFeelingsUC by lazy {
        GetFeelingsUC(userFeelingsRepositoryImpl)
    }

    private val userLiveData = MutableLiveData<User>()
    private val feelingsLiveData = MutableLiveData<ArrayList<Feeling>>()
    private val quotesLiveData = MutableLiveData<ArrayList<Quote>>()

    fun getUserLiveData(userData: UserData): MutableLiveData<User> {
        createUser(userData)
        return userLiveData
    }

    private fun createUser(userData: UserData) {
        viewModelScope.launch {
            try {
                val userDataResponse = postUserDataUC.execute(userData)
                userLiveData.value =
                    ResponseConverter.convertUserDataResponseToUser(userDataResponse)
            } catch (e: NullPointerException) {
                ToastHelper.makeToast(
                    context,
                    StringGetter.getString(context, R.string.loginErrorText)
                )
            }
        }
    }

    fun getFeelingsLiveData(): MutableLiveData<ArrayList<Feeling>> {
        fillFeelingsLiveData()
        return feelingsLiveData
    }

    private fun fillFeelingsLiveData() {
        viewModelScope.launch {
            val feelingsResponse = getFeelingsUC.execute()
            feelingsLiveData.value = feelingsResponse.data
        }
    }

    fun getQuotesLiveData(): MutableLiveData<ArrayList<Quote>> {
        fillQuotesLiveData()
        return  quotesLiveData
    }

    private fun fillQuotesLiveData() {
        viewModelScope.launch {
            val quotesResponse = getQuotesUC.execute()
            quotesLiveData.value = quotesResponse.data
        }
    }

}