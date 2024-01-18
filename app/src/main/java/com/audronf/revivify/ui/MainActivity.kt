package com.audronf.revivify.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.audronf.revivify.databinding.ActivityMainBinding
import com.audronf.revivify.model.CurrentWeather
import com.audronf.revivify.model.Timezone
import com.audronf.revivify.ui.adapter.TimezonesAdapter
import com.audronf.revivify.ui.viewmodel.WeatherViewModel
import com.audronf.revivify.utils.DateUtils
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val weatherViewModel: WeatherViewModel by viewModels()

    // TODO: Control this via RemoteConfig
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
            setWeatherState(it)
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

    private fun setWeatherState(currentWeather: CurrentWeather) {
        with(binding.currentWeather) {
            temperatureC.text = currentWeather.temperature.metric.value.toString()
            temperatureF.text = currentWeather.temperature.imperial.value.toString()
            weatherText.text = currentWeather.weatherText
            humidityValue.text = currentWeather.humidity.toString()
            uvValue.text = currentWeather.uvIndex.toString()
            lastUpdate.text = currentWeather.dateTime
            root.setOnClickListener {
                // TODO: Create an extension function to perform this action
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(currentWeather.link))
                startActivity(browserIntent)
            }
            sync.setOnClickListener { getWeatherState() }
        }
    }
}
