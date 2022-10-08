package com.example.meditationwsproject.presentation.activity.login_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meditationwsproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(this.layoutInflater)
    }

    private val viewModel by lazy {
        LoginActivityViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signInButtonOnClick()
        setContentView(binding.root)
    }

    private fun signInButtonOnClick() {
        binding.signInButton.setOnClickListener {
            viewModel.executeSomething(
                binding.emailEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
        }
    }
}