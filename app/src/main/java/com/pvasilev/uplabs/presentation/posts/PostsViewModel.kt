package com.pvasilev.uplabs.presentation.posts

import android.arch.lifecycle.ViewModel
import com.pvasilev.uplabs.presentation.mvi.MviViewModel
import io.reactivex.Observable

class PostsViewModel : ViewModel(), MviViewModel<PostsIntent, PostsViewState> {
    override fun processIntents(intents: Observable<PostsIntent>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun states(): Observable<PostsViewState> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}