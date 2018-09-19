package com.pvasilev.uplabs.presentation.posts

import com.pvasilev.uplabs.presentation.mvi.MviIntent

sealed class PostsIntent : MviIntent {
    object InitialIntent : PostsIntent()

    data class RefreshIntent(val filter: PostsFilterType) : PostsIntent()

    data class LoadMoreIntent(val page: Int, val filter: PostsFilterType) : PostsIntent()

    data class ChangeFilterIntent(val filter: PostsFilterType) : PostsIntent()
}