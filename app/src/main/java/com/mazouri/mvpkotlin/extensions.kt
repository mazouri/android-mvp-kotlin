package com.mazouri.mvpkotlin

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Alexey on 07.10.2016.
 */

fun String.formatDate(): String {
    val initialFormat = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'", Locale.ENGLISH)
    val format = SimpleDateFormat("yyyy-M-dd", Locale.US)
    val date = initialFormat.parse(this)
    return format.format(date).toString()
}

inline fun <reified T> Gson.fromJson(json: String): T {
    return this.fromJson<T>(json, object: TypeToken<T>() {}.type)
}

