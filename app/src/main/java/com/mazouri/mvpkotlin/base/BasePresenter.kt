package com.mazouri.mvpkotlin.base

import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * 1.Presenter基类，实现IPresenter接口
 *
 * 2.提供attachView和detachView方法的基本实现
 *
 * 3.持有View引用，子类可以通过getView()方法获取到
 *
 * Created by wangdongdong on 17-5-19.
 */

//Kotlin 里类默认都是final的,如果声明的类允许被继承则需要使用open关键字来描述类

//接口继承class Child : MyInterface{}
open class BasePresenter<T:IView> : IPresenter<T> {

    //setter方法
    //也可以写成一行(需要加分号),var view: T?=null;private set
    var view: T? = null
        private set // setter 是私有的并且有默认的实现

    private val mCompositeSubscription = CompositeSubscription()

    //函数默认也是final的,不能被override,要想重写父类函数,父类函数必须使用open定义
    override fun attachView(view: T) {
        this.view = view
    }

    override fun detachView() {
        view = null

        if (!mCompositeSubscription.isUnsubscribed) {
            mCompositeSubscription.clear()
        }
    }

    //getter方法
    val isViewAttached: Boolean
        get() = view != null

    fun checkViewAttached() {
        if (!isViewAttached) throw ViewNotAttachedException()
    }

    fun addSubscription(subs: Subscription) {
        mCompositeSubscription.add(subs)
    }

    //internal 修饰符是指成员的可见性是只在同一个模块(module)中才可见的
    private class ViewNotAttachedException internal constructor() : RuntimeException("Please call Presenter.attachView(MvpView) before" + " requesting data to the Presenter")


}