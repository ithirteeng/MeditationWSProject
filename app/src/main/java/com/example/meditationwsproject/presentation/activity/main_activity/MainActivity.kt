package com.example.meditationwsproject.presentation.activity.main_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meditationwsproject.databinding.ActivityMainBinding
import com.example.meditationwsproject.presentation.activity.login_activity.LoginActivity
import com.example.meditationwsproject.presentation.model.User

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(this.layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val user = getUser()
        binding.nicknameTextView.text = user.nickname

    }

    private fun getUser(): User {
        return intent.getSerializableExtra(LoginActivity.LOGIN_INTENT_KEY) as User
    }
}