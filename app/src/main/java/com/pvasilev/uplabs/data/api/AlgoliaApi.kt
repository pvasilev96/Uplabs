package com.pvasilev.uplabs.data.api

import com.pvasilev.uplabs.data.model.Collection
import com.pvasilev.uplabs.data.model.Post
import com.pvasilev.uplabs.data.model.SearchResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AlgoliaApi {
    @GET("1/indexes/uplabs_production_heroku")
    fun searchPosts(
            @Query("query") query: String? = null,
            @Query("facets") facets: String? = null,
            @Query("facetFilters") facetFilters: List<String>? = null,
            @Query("numericFilters") numericFilters: List<String>? = null,
            @Query("hitsPerPage") hitsPerPage: Int
    ): Single<SearchResult<Post>>

    @GET("1/indexes/collections_production_heroku")
    fun searchCollections(
            @Query("query") query: String? = null,
            @Query("facets") facets: String? = null,
            @Query("facetFilters") facetFilters: List<String>? = null,
            @Query("numericFilters") numericFilters: List<String>? = null,
            @Query("hitsPerPage") hitsPerPage: Int
    ): Single<SearchResult<Collection>>
}