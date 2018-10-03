package com.pvasilev.uplabs.presentation.posts

import com.pvasilev.uplabs.data.source.posts.PostsRepository
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostsActionProcessor @Inject constructor(private val postsRepository: PostsRepository) : ObservableTransformer<PostsAction, PostsResult> {
    override fun apply(upstream: Observable<PostsAction>): ObservableSource<PostsResult> {
        return upstream.publish { shared ->
            Observable.mergeArray(
                    shared.ofType(PostsAction.LoadPostsAction::class.java).compose(loadPostsProcessor)
            )
        }
    }

    private val loadPostsProcessor = ObservableTransformer<PostsAction.LoadPostsAction, PostsResult> { actions ->
        actions.flatMap { action ->
            postsRepository.getPosts(action.page, action.filterType).toObservable()
                    .map { posts -> PostsResult.LoadingResult.Success(posts) }
                    .cast(PostsResult.LoadingResult::class.java)
                    .onErrorReturn(PostsResult.LoadingResult::Failure)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }
}