package com.pvasilev.uplabs.presentation.posts

import com.pvasilev.uplabs.presentation.mvi.MviIntent

sealed class PostsIntent : MviIntent {
    object InitialIntent : PostsIntent()

    object RefreshIntent : PostsIntent()

    data class LoadMoreIntent(val page: Int) : PostsIntent()

    data class ChangeFilterIntent(val filter: PostsFilterType) : PostsIntent()
}