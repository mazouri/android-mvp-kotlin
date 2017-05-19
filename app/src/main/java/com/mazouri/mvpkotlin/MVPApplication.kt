package com.mazouri.mvpkotlin

import android.app.Application
import timber.log.Timber

/**
 * Created by wangdongdong on 17-5-19.
 */

class MVPApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
