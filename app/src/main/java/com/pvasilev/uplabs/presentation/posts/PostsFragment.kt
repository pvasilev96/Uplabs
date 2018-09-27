package com.pvasilev.uplabs.presentation.posts

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.support.v4.widget.refreshes
import com.jakewharton.rxbinding2.view.clicks
import com.pvasilev.uplabs.R
import com.pvasilev.uplabs.presentation.UplabsViewModelFactory
import com.pvasilev.uplabs.presentation.mvi.MviView
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_posts_expanded.*
import kotlinx.android.synthetic.main.layout_backdrop.*
import kotlinx.android.synthetic.main.layout_list.*

class PostsFragment : Fragment(), MviView<PostsIntent, PostsViewState> {
    private val viewModel: PostsViewModel by lazy {
        ViewModelProviders.of(this, UplabsViewModelFactory)
                .get(PostsViewModel::class.java)
    }

    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_posts_expanded, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        toolbar.inflateMenu(R.menu.main_menu)
    }

    override fun onResume() {
        super.onResume()
        viewModel.processIntents(intents())
        disposables.add(viewModel.states().subscribe(this::render))
    }

    override fun onPause() {
        super.onPause()
        disposables.clear()
    }

    override fun intents(): Observable<PostsIntent> =
            Observable.merge(
                    initialIntent(),
                    refreshIntent(),
                    changeFilterIntent()
            )

    override fun render(state: PostsViewState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun initialIntent(): Observable<PostsIntent.InitialIntent> =
            Observable.just(PostsIntent.InitialIntent)

    private fun refreshIntent(): Observable<PostsIntent.RefreshIntent> =
            swipeToRefresh.refreshes().map { PostsIntent.RefreshIntent(PostsFilterType.ANDROID) }


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
}