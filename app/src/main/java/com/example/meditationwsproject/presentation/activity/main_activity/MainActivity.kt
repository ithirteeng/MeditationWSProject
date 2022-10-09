package com.example.meditationwsproject.presentation.activity.main_activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
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

    private val viewModel by lazy {
        MainActivityViewModel(this.application)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val userData = getUserData()
        viewModel.getLiveData(userData).observe(this) {
            binding.nicknameTextView.text = "${it.nickname}\n${it.email}\n${it.avatar}"
            binding.progressBar.visibility = View.GONE
        }

    }

    private fun getUserData(): UserData {
        return intent.getSerializableExtra(INTENT_KEY) as UserData
    }
}