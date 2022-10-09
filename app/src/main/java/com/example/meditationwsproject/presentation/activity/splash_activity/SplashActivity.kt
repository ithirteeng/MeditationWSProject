package com.example.meditationwsproject.presentation.activity.splash_activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meditationwsproject.data.local_storage.UserDataStorage
import com.example.meditationwsproject.databinding.ActivitySplashBinding
import com.example.meditationwsproject.domain.model.UserData
import com.example.meditationwsproject.presentation.activity.main_activity.MainActivity
import com.example.meditationwsproject.presentation.activity.onboarding_activity.OnboardingActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySplashBinding.inflate(this.layoutInflater)
    }

    private val viewModel by lazy {
        SplashActivityViewModel(this.application)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val userDataEmail = viewModel.getUserEmail()

        CoroutineScope(Dispatchers.Main).launch {
            delay(1500)
            if (checkUserDataExisting(email = userDataEmail)) {
                onLiveDataChange()
            } else {
                startActivity(Intent(this@SplashActivity, OnboardingActivity::class.java))
            }
            finish()
        }
    }

    private fun checkUserDataExisting(email: String): Boolean {
        return email != UserDataStorage.EMPTINESS_CASE
    }

    private fun onLiveDataChange() {
        viewModel.getLiveData().observe(this) {
            makeIntent(it)
        }
    }

    private fun makeIntent(userData: UserData) {
        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        intent.putExtra(MainActivity.INTENT_KEY, userData)
        startActivity(intent)
    }


}