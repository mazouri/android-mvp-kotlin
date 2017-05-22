package com.mazouri.mvpkotlin.injection.component

import android.app.Application
import android.content.Context
import com.mazouri.mvpkotlin.injection.ApplicationContext
import com.mazouri.mvpkotlin.injection.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by wangdongdong on 17-5-22.
 */

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(activityComponent: ActivityComponent)

    @ApplicationContext
    fun context(): Context

    fun application(): Application
}