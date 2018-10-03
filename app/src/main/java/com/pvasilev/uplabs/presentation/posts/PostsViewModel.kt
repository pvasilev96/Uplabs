package com.pvasilev.uplabs.presentation.posts

import android.arch.lifecycle.ViewModel
import com.pvasilev.uplabs.presentation.mvi.MviViewModel
import com.pvasilev.uplabs.presentation.posts.PostsIntent.*
import com.pvasilev.uplabs.presentation.posts.PostsResult.LoadingResult
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class PostsViewModel @Inject constructor(postsActionProcessor: PostsActionProcessor) : ViewModel(), MviViewModel<PostsIntent, PostsViewState> {
    private val intentsSubject: PublishSubject<PostsIntent> = PublishSubject.create()

    private val statesObservable: Observable<PostsViewState> = intentsSubject
            .map(this::actionFromIntent)
            .compose(postsActionProcessor)
            .scan(PostsViewState.default(), this::reducer)

    override fun processIntents(intents: Observable<PostsIntent>) = intents.subscribe(intentsSubject)

    override fun states(): Observable<PostsViewState> = statesObservable

    private fun actionFromIntent(intent: PostsIntent): PostsAction = when (intent) {
        is InitialIntent -> PostsAction.LoadPostsAction(0, PostsFilterType.ANDROID)
        is RefreshIntent -> PostsAction.LoadPostsAction(0, intent.filter)
        is LoadMoreIntent -> PostsAction.LoadPostsAction(intent.page, intent.filter)
        is ChangeFilterIntent -> PostsAction.LoadPostsAction(0, intent.filter)
    }

    private fun reducer(previousState: PostsViewState, result: PostsResult): PostsViewState = when (result) {
        is LoadingResult -> when (result) {
            is LoadingResult.Success -> previousState.copy(isLoading = false, posts = result.posts)
            is LoadingResult.Failure -> previousState.copy(isLoading = false, error = result.error)
        }
    }
}