package com.pvasilev.uplabs.data.source

import com.pvasilev.uplabs.data.model.Post
import io.reactivex.Single

interface PostsDataSource {
    fun getPosts(): Single<List<Post>>

    fun getPost(id: Int): Single<Post>
}