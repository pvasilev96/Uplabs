package com.pvasilev.uplabs.presentation.mvi

import io.reactivex.Observable

interface MviView<I : MviIntent, S : MviViewState> {
    fun intents(): Observable<I>

    fun render(state: S)
}