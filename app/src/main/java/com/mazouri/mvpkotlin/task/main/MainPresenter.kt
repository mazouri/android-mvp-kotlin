package com.mazouri.mvpkotlin.task.main

import com.mazouri.mvpkotlin.data.ApiSettings
import com.mazouri.mvpkotlin.data.GeneralErrorHandler
import com.mazouri.mvpkotlin.data.GithubServiceFactory
import com.mazouri.mvpkotlin.injection.ConfigPersistent
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by wangdongdong on 17-5-22.
 */
@ConfigPersistent
class MainPresenter @Inject constructor(): MainContract.Presenter() {

    companion object {
        private val USER_NAME = "mazouri"
        private val REPOS_TYPE = "public"
    }

    override fun loadRepositories() {
        GithubServiceFactory.makeStarterService().getUserRepos(USER_NAME, REPOS_TYPE, ApiSettings.REPOS_SORT_BY_UPDATED)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { view?.showMessage(it.toString()) }
                .subscribe(Action1 { view?.showOrganizations(it) }
                        , GeneralErrorHandler(view, true, {
                    throwable, _, _ -> view?.showError(throwable.message)
                }))
    }

}