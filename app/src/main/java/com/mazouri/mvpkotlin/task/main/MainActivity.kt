package com.mazouri.mvpkotlin.task.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.mazouri.mvpkotlin.R
import com.mazouri.mvpkotlin.base.BaseActivity
import com.mazouri.mvpkotlin.data.model.Repository
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    private var mAdapter: RepositoriesAdapter? = null

    @Inject lateinit var mMainPresenter: MainPresenter

    override val layout: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent().inject(this)
        mMainPresenter.attachView(this)

        setupViews()

        mMainPresenter.loadRepositories()
    }

    override fun onDestroy() {
        super.onDestroy()
        mMainPresenter.detachView()
    }

    private fun setupViews() {
        mAdapter = RepositoriesAdapter(ArrayList<Repository>(), {

        })

        recyclerViewRepositories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewRepositories.adapter = mAdapter
    }

    override fun showOrganizations(repositories: MutableList<Repository>) {
        mAdapter?.addRepositories(repositories)
        mAdapter?.notifyDataSetChanged()
    }

    override fun showLoadReposFailed(error: String?) {

    }

    override fun showError(error: String?) {

    }

    override fun showError(stringResId: Int) {

    }


}
