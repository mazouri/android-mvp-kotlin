package com.mazouri.mvpkotlin.base

import com.mazouri.mvpkotlin.fromJson
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

import java.io.IOException

import retrofit2.Response


/**
 * Created by wangdongdong on 17-5-22.
 */

data class ErrorBody(val code: Int, @SerializedName("error") val message: String) {

    override fun toString(): String {
        return "{code:$code, message:\"$message\"}"
    }

    companion object {

        val UNKNOWN_ERROR = 0

        private val GSON = Gson()

        fun parseError(response: Response<*>?): ErrorBody? {
            return (response?.errorBody())?.let {
                try {
                    GSON.fromJson(it.string())
                } catch (ignored: IOException) {
                    null
                }
            }
        }
    }

}

