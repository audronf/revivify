package com.audronf.revivify.model

import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    @SerializedName("LocalObservationDateTime") val dateTime: String,
    @SerializedName("WeatherText") val weatherText: String,
    @SerializedName("WeatherIcon") val weatherIcon: Int = 1,
    @SerializedName("HasPrecipitation") val hasPrecipitation: Boolean = false,
    @SerializedName("IsDayTime") val isDayTime: Boolean = true,
    @SerializedName("Temperature") val temperature: TemperatureSystem,
    @SerializedName("Link") val link: String
)
