package com.mazouri.mvpkotlin.base

/**
 * Created by wangdongdong on 17-5-19.
 */
interface IPresenter<V:IView> {

    fun attachView(view:V)

    fun detachView()
}