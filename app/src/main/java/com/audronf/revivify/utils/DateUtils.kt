package com.audronf.revivify.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    private val defaultLocale = Locale("es-AR")

    fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("EEEE',' d 'de' MMMM 'de' yyyy", defaultLocale)
        val date = Date()
        return dateFormat.format(date)
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(defaultLocale) else it.toString() }
    }
}
