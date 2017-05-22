package com.mazouri.mvpkotlin.injection.component

import com.mazouri.mvpkotlin.base.BaseActivity
import com.mazouri.mvpkotlin.injection.PerActivity
import com.mazouri.mvpkotlin.injection.module.ActivityModule
import com.mazouri.mvpkotlin.task.main.MainActivity
import dagger.Subcomponent

/**
 * Created by wangdongdong on 17-5-22.
 */

@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(baseActivity: BaseActivity)
    fun inject(mainActivity: MainActivity)
}