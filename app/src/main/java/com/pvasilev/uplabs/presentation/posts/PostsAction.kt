package com.pvasilev.uplabs.presentation.posts

import com.pvasilev.uplabs.presentation.mvi.MviAction

sealed class PostsAction : MviAction {
    data class LoadPostsAction(val page: Int, val filterType: PostsFilterType) : PostsAction()
}