package com.pvasilev.uplabs.data.source.collections

import com.pvasilev.uplabs.data.api.AlgoliaApi
import com.pvasilev.uplabs.data.model.Collection
import io.reactivex.Single
import javax.inject.Inject

class CollectionsRemoteDataSource @Inject constructor(private val api: AlgoliaApi) : CollectionsDataSource {
    override fun getCollections(): Single<List<Collection>> =
            api.searchCollections(
                    hitsPerPage = 12
            )
                    .map { it.results }

    override fun getCollection(id: Int): Single<Collection> =
            api.searchCollections(
                    numericFilters = listOf("id=$id"),
                    hitsPerPage = 1
            )
                    .map { it.results }
                    .map { it.first() }
}