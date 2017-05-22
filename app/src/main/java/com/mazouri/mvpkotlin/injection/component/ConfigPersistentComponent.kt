package com.mazouri.mvpkotlin.injection.component

import com.mazouri.mvpkotlin.injection.ConfigPersistent
import com.mazouri.mvpkotlin.injection.module.ActivityModule
import com.mazouri.mvpkotlin.injection.module.FragmentModule
import dagger.Component

/**
 * Created by wangdongdong on 17-5-22.
 */
@ConfigPersistent
@Component(dependencies = arrayOf(ApplicationComponent::class))
interface ConfigPersistentComponent {

    fun activityComponent(activityModule: ActivityModule): ActivityComponent

    fun fragmentComponent(fragmentModule: FragmentModule): FragmentComponent

}