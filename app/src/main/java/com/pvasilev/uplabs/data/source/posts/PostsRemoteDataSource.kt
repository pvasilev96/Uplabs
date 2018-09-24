package com.pvasilev.uplabs.data.source.posts

import com.pvasilev.uplabs.data.api.AlgoliaApi
import com.pvasilev.uplabs.data.model.Post
import com.pvasilev.uplabs.presentation.posts.PostsFilterType
import io.reactivex.Single
import javax.inject.Inject

class PostsRemoteDataSource @Inject constructor(private val api: AlgoliaApi) : PostsDataSource {
    override fun getPosts(page: Int, category: PostsFilterType): Single<List<Post>> =
            api.searchPosts(
                    facets = "category_name",
                    facetFilters = listOf("category_name:$category"),
                    page = page,
                    hitsPerPage = 12
            )
                    .map { it.results }

    override fun getPost(id: Int): Single<Post> =
            api.searchPosts(
                    numericFilters = listOf("id=$id"),
                    page = 0,
                    hitsPerPage = 1
            )
                    .map { it.results }
                    .map { it.first() }

}