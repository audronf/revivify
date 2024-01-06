package com.audronf.revivify.repository

import com.audronf.revivify.network.service.WeatherService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherService: WeatherService) {

    suspend fun getCurrentWeather() = withContext(Dispatchers.IO) {
        weatherService.getCurrentWeather()
    }
}
