package com.mazouri.mvpkotlin.task.main

import android.support.annotation.StringRes
import com.mazouri.mvpkotlin.base.BasePresenter
import com.mazouri.mvpkotlin.base.IView
import com.mazouri.mvpkotlin.data.model.Repository

/**
 * Created by wangdongdong on 17-5-22.
 */
object MainContract {

    interface View: IView {
        fun showOrganizations(repositories: MutableList<Repository>)
        fun showLoadReposFailed(error: String?)
        fun showError(error: String?)
        fun showError(@StringRes stringResId: Int)
    }

    abstract class Presenter: BasePresenter<View>() {
        abstract fun loadRepositories()
    }
}