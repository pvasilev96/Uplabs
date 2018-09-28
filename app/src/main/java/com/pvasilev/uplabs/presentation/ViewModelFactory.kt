package com.pvasilev.uplabs.presentation

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.pvasilev.uplabs.di.DI
import com.pvasilev.uplabs.presentation.posts.PostsViewModel
import toothpick.Toothpick

object ViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass == PostsViewModel::class.java) {
            Toothpick.openScope(DI.POSTS_SCOPE).getInstance(modelClass) as T
        } else {
            throw IllegalArgumentException("Unknown view model class: $modelClass")
        }
    }
}