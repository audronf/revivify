package com.audronf.revivify.ui.components

import android.content.Context
import android.text.format.DateFormat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextClock
import android.widget.TextView
import com.audronf.revivify.R
import java.text.SimpleDateFormat
import java.util.*

class ExtraTimezone @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var labelTextView: TextView
    private var timeTextClock: TextClock

    init {
        // Inflate the layout
        LayoutInflater.from(context).inflate(R.layout.view_extra_timezone, this, true)

        // Find views
        labelTextView = findViewById(R.id.labelTextView)
        timeTextClock = findViewById(R.id.timeTextClock)

        // Handle custom attributes if needed

        // Set default time zone
        setTimeZone("Europe/Paris")
    }

    fun setTimeZone(timeZone: String) {
        timeTextClock.timeZone = timeZone
        updateTime()
    }

    fun setLabelText(labelText: String) {
        labelTextView.text = labelText
    }

    private fun updateTime() {
        // Format the current time in the specified time zone
        val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone(timeTextClock.timeZone)
        val formattedTime = sdf.format(System.currentTimeMillis())

        // Set the formatted time as the text for the TextClock
        timeTextClock.text = formattedTime
    }
}
