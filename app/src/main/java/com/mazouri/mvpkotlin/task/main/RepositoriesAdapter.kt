package com.mazouri.mvpkotlin.task.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mazouri.mvpkotlin.R
import com.mazouri.mvpkotlin.data.model.Repository
import kotlinx.android.synthetic.main.item_repository.view.*

/**
 * Created by wangdongdong on 17-5-22.
 */
class RepositoriesAdapter(private val repositories: MutableList<Repository>,
                          val onClick: (Repository) -> Unit)
    : RecyclerView.Adapter<RepositoriesAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindData(repositories[position])
    }

    override fun getItemCount(): Int = repositories.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_repository, parent, false).let {
            ViewHolder(it, onClick)
        }
    }

    class ViewHolder(itemView: View, val onClick: (Repository) -> Unit) : RecyclerView.ViewHolder(itemView) {

        fun bindData(repository: Repository) {
            with(repository) {
                itemView.text_view_title.text = name
                itemView.text_view_description.text = description
                itemView.setOnClickListener { onClick(this) }
            }
        }
    }

    fun addRepositories(newRepositories: List<Repository>) {
        repositories.addAll(newRepositories)
    }
}