package com.mazouri.mvpkotlin

import android.app.Application
import android.content.Context
import com.mazouri.mvpkotlin.injection.component.ApplicationComponent
import com.mazouri.mvpkotlin.injection.component.DaggerApplicationComponent
import com.mazouri.mvpkotlin.injection.module.ApplicationModule
import timber.log.Timber

/**
 * Created by wangdongdong on 17-5-19.
 */

class MVPApplication : Application() {

    internal var mApplicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    // Needed to replace the component with a test specific one
    var component: ApplicationComponent
        get() {
            if (mApplicationComponent == null) {
                mApplicationComponent = DaggerApplicationComponent.builder()
                        .applicationModule(ApplicationModule(this))
                        .build()
            }
            return mApplicationComponent as ApplicationComponent
        }
        set(applicationComponent) {
            mApplicationComponent = applicationComponent
        }

    companion object {
        operator fun get(context: Context): MVPApplication {
            return context.applicationContext as MVPApplication
        }
    }
}
