package com.audronf.revivify.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.audronf.revivify.model.CurrentWeather
import com.audronf.revivify.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
): ViewModel() {

    private val _weatherState: MutableLiveData<CurrentWeather> = MutableLiveData()
    val weatherState: LiveData<CurrentWeather>
        get() = _weatherState

    fun getCurrentWeather() {
        viewModelScope.launch {
            val response = weatherRepository.getCurrentWeather()
            if (response.isSuccessful) {
                _weatherState.postValue(response.body()?.first())
            } else {
                // Error handling
            }
        }
    }
}
