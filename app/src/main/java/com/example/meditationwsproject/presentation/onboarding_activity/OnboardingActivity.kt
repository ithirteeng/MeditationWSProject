package com.example.meditationwsproject.presentation.onboarding_activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meditationwsproject.databinding.ActivityOnboardingBinding
import com.example.meditationwsproject.presentation.login_activity.LoginActivity
import com.example.meditationwsproject.presentation.registration_activity.RegistrationActivity

class OnboardingActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityOnboardingBinding.inflate(this.layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        enteringButtonOnCLick()
        registrationTextOnClick()
    }

    private fun enteringButtonOnCLick() {
        binding.enteringButton.setOnClickListener {
            startActivity(Intent(this@OnboardingActivity, LoginActivity::class.java))
        }
    }

    private fun registrationTextOnClick() {
        binding.registrationTextView.setOnClickListener {
            startActivity(Intent(this@OnboardingActivity, RegistrationActivity::class.java))
        }
    }
}