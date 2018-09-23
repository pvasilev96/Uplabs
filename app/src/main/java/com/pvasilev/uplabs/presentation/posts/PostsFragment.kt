package com.pvasilev.uplabs.presentation.posts

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import com.pvasilev.uplabs.presentation.UplabsViewModelFactory
import com.pvasilev.uplabs.presentation.mvi.MviView
import io.reactivex.Observable

class PostsFragment : Fragment(), MviView<PostsIntent, PostsViewState> {
    private val viewModel: PostsViewModel by lazy {
        ViewModelProviders.of(this, UplabsViewModelFactory)
                .get(PostsViewModel::class.java)
    }

    override fun intents(): Observable<PostsIntent> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun render(state: PostsViewState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}