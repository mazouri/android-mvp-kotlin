package com.mazouri.mvpkotlin.base

/**
 * Created by wangdongdong on 17-5-19.
 */

open class BasePresenter<T:IView> : IPresenter<T> {
    var view: T? = null

    override fun attachView(view: T) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

}