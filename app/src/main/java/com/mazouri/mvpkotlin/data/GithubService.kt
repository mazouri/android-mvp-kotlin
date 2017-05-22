package com.mazouri.mvpkotlin.data

import com.mazouri.mvpkotlin.data.model.Repository
import com.mazouri.mvpkotlin.data.model.RepositoryDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

/**
 * Created by wangdongdong on 17-5-22.
 */
interface GithubService {

    @GET(ApiSettings.USER_REPOS)
    fun getUserRepos(@Path(ApiSettings.PATH_USER) organizationName: String,
                     @Query(ApiSettings.PARAM_REPOS_TYPE) reposType: String,
                     @Query(ApiSettings.REPOS_SORT) sortType: String): Observable<MutableList<Repository>>

    @GET(ApiSettings.REPOSITORY)
    fun getRepository(@Path(ApiSettings.PATH_OWNER) owner: String,
                      @Path(ApiSettings.PATH_REPO) name: String): Observable<RepositoryDetail>
}