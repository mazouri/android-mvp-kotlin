package com.mazouri.mvpkotlin.data

/**
 * Created by wangdongdong on 17-5-22.
 */
//对象声明
object ApiSettings {
    const val PATH_USER = "users"
    const val PARAM_REPOS_TYPE = "type"

    const val PATH_REPO = "repo"
    const val PATH_OWNER = "owner"

    const val USER_REPOS = "users/{$PATH_USER}/repos"
    const val REPOSITORY = "/repos/{$PATH_OWNER}/{$PATH_REPO}"

    const val REPOS_SORT = "sort"
    const val REPOS_SORT_BY_UPDATED = "updated"
}