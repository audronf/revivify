package com.audronf.revivify.extension

import android.app.Activity
import android.content.Intent
import android.net.Uri

fun Activity.openBrowser(uri: String) {
    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
    startActivity(browserIntent)
}
