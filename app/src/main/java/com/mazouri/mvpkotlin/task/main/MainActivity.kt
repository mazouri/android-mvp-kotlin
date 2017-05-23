package com.mazouri.mvpkotlin.task.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
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

        showProgress()
        fab.setOnClickListener {
            showProgress()
            mMainPresenter.loadRepositories(getRepoUser())
        }
        mMainPresenter.loadRepositories(getRepoUser())
    }

    private fun getRepoUser(): String {
        return edit.text.toString().trim()
    }

    override fun onDestroy() {
        super.onDestroy()
        mMainPresenter.detachView()
    }

    private fun setupViews() {
        mAdapter = RepositoriesAdapter(ArrayList<Repository>(), {
            Toast.makeText(this, "您选择了" + it.name, Toast.LENGTH_SHORT).show()
        })

        recyclerViewRepositories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewRepositories.adapter = mAdapter
    }

    private fun showProgress() {
        recyclerViewRepositories.visibility = View.GONE
        progress_bar.visibility = View.VISIBLE
        fab.isEnabled = false
    }

    private fun hideProgress() {
        recyclerViewRepositories.visibility = View.VISIBLE
        progress_bar.visibility = View.GONE
        fab.isEnabled = true
    }

    override fun showOrganizations(repositories: MutableList<Repository>) {
        mAdapter?.addRepositories(repositories)
        mAdapter?.notifyDataSetChanged()
        hideProgress()
    }

    override fun showLoadReposFailed(error: String?) {

        hideProgress()
    }

    override fun showError(error: String?) {

    }

    override fun showError(stringResId: Int) {

    }


}
