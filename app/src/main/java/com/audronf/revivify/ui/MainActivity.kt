package com.audronf.revivify.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.audronf.revivify.databinding.ActivityMainBinding
import com.audronf.revivify.model.Timezone
import com.audronf.revivify.ui.adapter.TimezonesAdapter
import com.audronf.revivify.ui.viewmodel.WeatherViewModel
import com.audronf.revivify.utils.DateUtils
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val weatherViewModel: WeatherViewModel by viewModels()

    private val extraTimezones = listOf(
        Timezone("Los Angeles: ", "America/Los_Angeles"),
        Timezone("New York: ", "America/New_York"),
        Timezone("Paris: ", "Europe/Paris"),
        Timezone("Tokyo: ", "Asia/Tokyo"),
        Timezone("Sydney: ", "Australia/Sydney")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(binding.root)
        setDate()
        setExtraTimezonesAdapter()
        weatherViewModel.weatherState.observe(this) {
            Log.e("Weather", it.toString())
        }
        getWeatherState()
    }

    private fun setExtraTimezonesAdapter() {
        binding.extraTimezones.apply {
            adapter = TimezonesAdapter().apply {
                submitList(extraTimezones)
            }
            layoutManager = LinearLayoutManager(this@MainActivity)
            isNestedScrollingEnabled = false
            visibility = View.VISIBLE
        }
    }
    private fun setDate() {
        binding.currentDate.text = DateUtils.getCurrentDate()
    }

    private fun getWeatherState() {
        weatherViewModel.getCurrentWeather()
    }
}
