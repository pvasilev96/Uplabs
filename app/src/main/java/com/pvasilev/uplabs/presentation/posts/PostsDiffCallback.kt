package com.pvasilev.uplabs.presentation.posts

import android.support.v7.util.DiffUtil
import com.pvasilev.uplabs.data.model.Post

class PostsDiffCallback : DiffUtil.ItemCallback<Post?>() {
    override fun areItemsTheSame(oldItem: Post?, newItem: Post?): Boolean = oldItem?.id == newItem?.id

    override fun areContentsTheSame(oldItem: Post?, newItem: Post?): Boolean = oldItem == newItem
}