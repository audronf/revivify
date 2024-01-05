package com.audronf.revivify.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.audronf.revivify.databinding.ActivityMainBinding
import com.audronf.revivify.utils.DateUtils

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(binding.root)
        setDate()
    }

    private fun setDate() {
        binding.currentDate.text = DateUtils.getCurrentDate()
        binding.parisTimezone.setLabelText("Paris: ")
        binding.parisTimezone.setTimeZone("Europe/Paris")
        binding.losAngelesTimezone.setLabelText("Los Angeles: ")
        binding.losAngelesTimezone.setTimeZone("America/Los_Angeles")
        binding.tokyoTimezone.setLabelText("Tokyo: ")
        binding.tokyoTimezone.setTimeZone("Asia/Tokyo")
    }
}
