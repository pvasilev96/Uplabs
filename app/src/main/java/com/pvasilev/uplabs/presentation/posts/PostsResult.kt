package com.pvasilev.uplabs.presentation.posts

import com.pvasilev.uplabs.data.model.Post
import com.pvasilev.uplabs.presentation.mvi.MviResult

sealed class PostsResult : MviResult {
    sealed class LoadingResult : PostsResult() {
        data class Success(val posts: List<Post>) : LoadingResult()

        data class Failure(val error: Throwable) : LoadingResult()
    }
}