package com.mazouri.mvpkotlin.task.main

import com.mazouri.mvpkotlin.data.ApiSettings
import com.mazouri.mvpkotlin.data.GithubServiceFactory
import com.mazouri.mvpkotlin.data.model.Repository
import com.mazouri.mvpkotlin.injection.ConfigPersistent
import rx.android.schedulers.AndroidSchedulers
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

    override fun loadRepositories(repoUser: String?) {
        GithubServiceFactory.makeStarterService().getUserRepos(checkRepoUser(repoUser), REPOS_TYPE, ApiSettings.REPOS_SORT_BY_UPDATED)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { view?.showError(it.toString()) }
                .subscribe(
                        { onLoadReposSuccess(it) },
                        { onLoadReposFailed(it) }
                )
    }

    private fun checkRepoUser(repoUser: String?): String {
        if (repoUser == null || repoUser.length == 0)
            return USER_NAME
        else return repoUser
    }

    private fun onLoadReposSuccess(it: MutableList<Repository>) {
        view?.showOrganizations(it)
    }

    private fun onLoadReposFailed(it: Throwable) {
        view?.showLoadReposFailed(it.message)
    }



}