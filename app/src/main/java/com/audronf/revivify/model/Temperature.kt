package com.audronf.revivify.model

import com.google.gson.annotations.SerializedName

data class TemperatureSystem(
    @SerializedName("Metric") val metric: Temperature,
    @SerializedName("Imperial") val imperial: Temperature
)

data class Temperature(
    @SerializedName("Value") val value: Double,
    @SerializedName("Unit") val unit: String = "C"
)
