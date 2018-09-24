package com.pvasilev.uplabs.data.source.posts

import com.pvasilev.uplabs.data.model.Post
import com.pvasilev.uplabs.presentation.posts.PostsFilterType
import io.reactivex.Single

interface PostsDataSource {
    fun getPosts(page: Int, category: PostsFilterType): Single<List<Post>>

    fun getPost(id: Int): Single<Post>
}