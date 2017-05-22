package com.mazouri.mvpkotlin.base

import android.support.annotation.StringRes

/**
 * Created by wangdongdong on 17-5-19.
 */
interface IView {
    fun showError(error: String?)

    fun showError(@StringRes stringResId: Int)

    fun showMessage(@StringRes srtResId: Int)

    fun showMessage(message: String)
}