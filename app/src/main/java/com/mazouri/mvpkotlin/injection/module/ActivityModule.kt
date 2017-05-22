package com.mazouri.mvpkotlin.injection.module

import android.app.Activity
import android.content.Context
import com.mazouri.mvpkotlin.data.GithubService
import com.mazouri.mvpkotlin.data.GithubServiceFactory
import com.mazouri.mvpkotlin.injection.ActivityContext
import com.mazouri.mvpkotlin.injection.ApplicationContext
import com.mazouri.mvpkotlin.task.main.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by wangdongdong on 17-5-22.
 */
@Module
class ActivityModule(private val mActivity: Activity) {

    @Provides
    internal fun provideActivity(): Activity {
        return mActivity
    }

    @Provides
    @ActivityContext
    internal fun provideContext(): Context {
        return mActivity
    }

    @Provides
    @ActivityContext
    internal fun provideGithubService(): GithubService {
        return GithubServiceFactory.makeStarterService()
    }
}