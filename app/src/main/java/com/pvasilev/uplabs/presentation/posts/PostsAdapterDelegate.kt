package com.pvasilev.uplabs.presentation.posts

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate
import com.pvasilev.uplabs.R
import com.pvasilev.uplabs.data.model.Post

class PostsAdapterDelegate : AdapterDelegate<List<Post?>>() {
    override fun isForViewType(items: List<Post?>, position: Int) = items[position] != null

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostVH(itemView)
    }

    override fun onBindViewHolder(items: List<Post?>, position: Int, holder: RecyclerView.ViewHolder, payloads: MutableList<Any>) {
        (holder as PostVH).bind(items[position]!!)
    }

    class PostVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: Post) {
            Glide.with(itemView)
                    .load(post.teaser)
                    .into(itemView as ImageView)
        }
    }
}