package com.pvasilev.uplabs.presentation.posts

import com.pvasilev.uplabs.data.model.Post
import com.pvasilev.uplabs.presentation.mvi.MviViewState

data class PostsViewState(
        val isLoading: Boolean,
        val posts: List<Post>,
        val error: Throwable?
) : MviViewState {
    companion object {
        fun default() = PostsViewState(true, listOf(), null)
    }
}