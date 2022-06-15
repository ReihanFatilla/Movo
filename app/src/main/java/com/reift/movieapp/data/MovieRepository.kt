package com.reift.movieapp.data

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager

class MovieRepository(context: Context) {
    val ai: ApplicationInfo = context.packageManager
        .getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
    val value = ai.metaData["apiKey"]
}