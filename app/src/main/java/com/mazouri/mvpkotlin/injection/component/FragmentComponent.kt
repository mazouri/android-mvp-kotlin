package com.mazouri.mvpkotlin.injection.component

import com.mazouri.mvpkotlin.injection.PerFragment
import com.mazouri.mvpkotlin.injection.module.FragmentModule
import dagger.Subcomponent

/**
 * Created by wangdongdong on 17-5-22.
 */
@PerFragment
@Subcomponent(modules = arrayOf(FragmentModule::class))
interface FragmentComponent