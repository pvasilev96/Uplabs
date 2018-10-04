package com.pvasilev.uplabs.presentation.posts

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate
import com.pvasilev.uplabs.R

class ProgressAdapterDelegate<T> : AdapterDelegate<List<T>>() {
    override fun isForViewType(items: List<T>, position: Int) = items[position] == null

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_progress, parent, false)
        return ProgressVH(itemView)
    }

    override fun onBindViewHolder(items: List<T>, position: Int, holder: RecyclerView.ViewHolder, payloads: MutableList<Any>) {
    }

    class ProgressVH(itemView: View) : RecyclerView.ViewHolder(itemView)
}