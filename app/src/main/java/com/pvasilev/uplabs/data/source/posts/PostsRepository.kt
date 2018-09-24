package com.pvasilev.uplabs.data.source.posts

import com.pvasilev.uplabs.data.model.Post
import com.pvasilev.uplabs.presentation.posts.PostsFilterType
import io.reactivex.Single
import javax.inject.Inject

class PostsRepository @Inject constructor(private val remoteDataSource: PostsRemoteDataSource) : PostsDataSource {
    override fun getPosts(category: PostsFilterType): Single<List<Post>> = remoteDataSource.getPosts(category)

    override fun getPost(id: Int): Single<Post> = remoteDataSource.getPost(id)
}