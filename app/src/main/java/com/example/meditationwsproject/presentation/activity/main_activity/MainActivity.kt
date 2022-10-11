package com.example.meditationwsproject.presentation.activity.main_activity

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.meditationwsproject.R
import com.example.meditationwsproject.databinding.ActivityMainBinding
import com.example.meditationwsproject.domain.model.UserData
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val userData = getUserData()
        viewModel.getUserLiveData(userData).observe(this) {
            binding.progressBar.visibility = View.GONE
        }

        changeTabsColor()


    }

    private fun changeTabsColor() {
        var color = resources.getColor(R.color.white, theme)
        binding.tabLayout.getTabAt(0)!!.icon!!.colorFilter = PorterDuffColorFilter(
            color,
            PorterDuff.Mode.SRC_IN
        )
        binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                color = resources.getColor(R.color.white, theme)
                tab.icon!!.colorFilter = PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                color = resources.getColor(R.color.progress_bar_color, theme)
                tab.icon!!.colorFilter = PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
    }

    private fun getUserData(): UserData {
        return intent.getSerializableExtra(INTENT_KEY) as UserData
    }
}