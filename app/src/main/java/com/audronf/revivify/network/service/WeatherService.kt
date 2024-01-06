package com.audronf.revivify.network.service

import com.audronf.revivify.model.CurrentWeather
import retrofit2.Response
import retrofit2.http.GET

interface WeatherService {

    @GET("currentconditions/v1/7894?apikey=V4oH5Gfyhi9AAAynqsVU7mpIualHum4h&language=es-ar")
    suspend fun getCurrentWeather(): Response<Array<CurrentWeather>>
}
