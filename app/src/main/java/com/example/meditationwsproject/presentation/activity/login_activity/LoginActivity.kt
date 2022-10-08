package com.example.meditationwsproject.presentation.activity.login_activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.example.meditationwsproject.databinding.ActivityLoginBinding
import com.example.meditationwsproject.presentation.activity.main_activity.MainActivity
import com.example.meditationwsproject.presentation.model.User

class LoginActivity : AppCompatActivity() {

    companion object {
        const val INTENT_KEY = "toMainActivity"
    }

    private val binding by lazy {
        ActivityLoginBinding.inflate(this.layoutInflater)
    }

    private val viewModel by lazy {
        LoginActivityViewModel(this.application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signInButtonOnClick()
        setContentView(binding.root)
    }

    private fun signInButtonOnClick() {
        binding.signInButton.setOnClickListener {
            viewModel.createUserData(
                binding.emailEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
            viewModel.getLiveData().observe(this) {
                makeIntent(it)
            }
        }
    }

    private fun makeIntent(user: User) {
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        intent.putExtra(INTENT_KEY, user)
        startActivity(intent)
    }

}