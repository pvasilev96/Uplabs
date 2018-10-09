package com.pvasilev.uplabs.presentation.posts

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager
import com.hannesdorfmann.adapterdelegates3.AsyncListDifferDelegationAdapter
import com.jakewharton.rxbinding2.support.v4.widget.refreshes
import com.jakewharton.rxbinding2.view.clicks
import com.jakewharton.rxbinding2.view.scrollChangeEvents
import com.pvasilev.uplabs.R
import com.pvasilev.uplabs.data.model.Post
import com.pvasilev.uplabs.presentation.ViewModelFactory
import com.pvasilev.uplabs.presentation.mvi.MviView
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_posts_expanded.*
import kotlinx.android.synthetic.main.layout_backdrop.*
import kotlinx.android.synthetic.main.layout_list.*

class PostsFragment : Fragment(), MviView<PostsIntent, PostsViewState> {
    private val viewModel: PostsViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory)
                .get(PostsViewModel::class.java)
    }

    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_posts_expanded, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        toolbar.inflateMenu(R.menu.main_menu)
        recyclerView.adapter = AsyncListDifferDelegationAdapter(
                PostsDiffCallback(),
                AdapterDelegatesManager<List<Post?>>()
                        .addDelegate(PostsAdapterDelegate())
                        .addDelegate(ProgressAdapterDelegate())
        )
        recyclerView.layoutManager = GridLayoutManager(context, 2).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int =
                        if ((recyclerView.adapter as AsyncListDifferDelegationAdapter<*>).items[position] != null) 1
                        else 2
            }
        }
    }

    override fun onStart() {
        super.onStart()
        disposables.add(viewModel.states().subscribe(this::render))
        viewModel.processIntents(intents())
    }

    override fun onStop() {
        super.onStop()
        disposables.clear()
    }

    override fun intents(): Observable<PostsIntent> =
            Observable.merge(
                    initialIntent(),
                    refreshIntent(),
                    loadMoreIntent(),
                    changeFilterIntent()
            )

    override fun render(state: PostsViewState) {
        val adapter = recyclerView.adapter as AsyncListDifferDelegationAdapter<*>
        adapter.items = state.posts
        swipeToRefresh.isRefreshing = state.isLoading
    }

    private fun initialIntent(): Observable<PostsIntent.InitialIntent> =
            Observable.just(PostsIntent.InitialIntent)

    private fun refreshIntent(): Observable<PostsIntent.RefreshIntent> =
            swipeToRefresh.refreshes().map { PostsIntent.RefreshIntent(getSelectedCategory()) }


    private fun changeFilterIntent(): Observable<PostsIntent.ChangeFilterIntent> =
            Observable.mergeArray(
                    btn_illustration.clicks().map { PostsFilterType.ILLUSTRATION },
                    btn_android.clicks().map { PostsFilterType.ANDROID },
                    btn_ios.clicks().map { PostsFilterType.IOS },
                    btn_web.clicks().map { PostsFilterType.WEB },
                    btn_ar.clicks().map { PostsFilterType.AR },
                    btn_branding.clicks().map { PostsFilterType.BRANDING },
                    btn_motion.clicks().map { PostsFilterType.MOTION }
            ).distinctUntilChanged().map { PostsIntent.ChangeFilterIntent(it) }

    private fun loadMoreIntent(): Observable<PostsIntent.LoadMoreIntent> =
            recyclerView.scrollChangeEvents()
                    .filter {
                        val layoutManager = recyclerView.layoutManager as GridLayoutManager
                        val isLoading = (recyclerView.adapter as AsyncListDifferDelegationAdapter<*>).items.contains(null)
                        !isLoading && layoutManager.findFirstVisibleItemPosition() + layoutManager.childCount >= layoutManager.itemCount
                    }
                    .map { PostsIntent.LoadMoreIntent((recyclerView.adapter.itemCount / 12) + 1, getSelectedCategory()) }

    private fun getSelectedCategory(): PostsFilterType =
            when (category_group.checkedRadioButtonId) {
                R.id.btn_illustration -> PostsFilterType.ILLUSTRATION
                R.id.btn_android -> PostsFilterType.ANDROID
                R.id.btn_ios -> PostsFilterType.IOS
                R.id.btn_web -> PostsFilterType.WEB
                R.id.btn_ar -> PostsFilterType.AR
                R.id.btn_branding -> PostsFilterType.BRANDING
                R.id.btn_motion -> PostsFilterType.MOTION
                else -> PostsFilterType.ANDROID
            }
}