package com.audronf.revivify.model

import android.content.Context
import com.audronf.revivify.R
import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    @SerializedName("LocalObservationDateTime") val dateTime: String,
    @SerializedName("WeatherText") val weatherText: String,
    @SerializedName("WeatherIcon") val weatherIcon: Int = 1,
    @SerializedName("HasPrecipitation") val hasPrecipitation: Boolean = false,
    @SerializedName("IsDayTime") val isDayTime: Boolean = true,
    @SerializedName("Temperature") val temperature: TemperatureSystem,
    @SerializedName("Link") val link: String,
    @SerializedName("RelativeHumidity") val humidity: Int,
    @SerializedName("UVIndex") val uvIndex: Int,
    @SerializedName("UVIndexText") val uvIndexText: String
) {

    fun getWeatherIconResource(): Int {
        return when (weatherIcon) {
            in 1..4 -> R.drawable.ic_sunny
            in 5..6 -> R.drawable.ic_partly_cloudy_day
            in 7..11 -> R.drawable.ic_cloudy
            in 12..18 -> R.drawable.ic_rainy
            in 19..21 -> R.drawable.ic_partly_cloudy_day
            in 33..34 -> R.drawable.ic_clear_night
            in 35..38 -> R.drawable.ic_partly_cloudy_night
            else -> R.drawable.ic_sunny
        }
    }
}
