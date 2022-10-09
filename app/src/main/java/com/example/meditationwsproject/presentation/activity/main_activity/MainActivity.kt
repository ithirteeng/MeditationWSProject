package com.example.meditationwsproject.presentation.activity.main_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meditationwsproject.databinding.ActivityMainBinding
import com.example.meditationwsproject.domain.model.UserData

class MainActivity : AppCompatActivity() {

    companion object {
        const val INTENT_KEY = "toMainActivity"
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(this.layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val user = getUserData()
        binding.nicknameTextView.text = user.email

    }

    private fun getUserData(): UserData {
        return intent.getSerializableExtra(INTENT_KEY) as UserData
    }
}