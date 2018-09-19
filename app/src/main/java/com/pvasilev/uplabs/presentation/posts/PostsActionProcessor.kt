package com.pvasilev.uplabs.presentation.posts

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer

class PostsActionProcessor : ObservableTransformer<PostsAction, PostsResult> {
    override fun apply(upstream: Observable<PostsAction>): ObservableSource<PostsResult> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}