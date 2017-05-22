package com.mazouri.mvpkotlin.base

/**
 * Created by wangdongdong on 17-5-19.
 */
interface IPresenter<in V:IView> {

    /**
     * 注入View，使之能够与View相互响应
     */
    fun attachView(view:V)

    /**
     * 释放资源
     */
    fun detachView()
}