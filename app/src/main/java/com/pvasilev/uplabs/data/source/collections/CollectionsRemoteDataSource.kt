package com.pvasilev.uplabs.data.source.collections

import com.pvasilev.uplabs.data.api.AlgoliaApi
import com.pvasilev.uplabs.data.model.Collection
import io.reactivex.Single
import javax.inject.Inject

class CollectionsRemoteDataSource @Inject constructor(private val api: AlgoliaApi) : CollectionsDataSource {
    override fun getCollections(page: Int): Single<List<Collection>> =
            api.searchCollections(
                    page = page,
                    hitsPerPage = 12
            )
                    .map { it.results }

    override fun getCollection(id: Int): Single<Collection> =
            api.searchCollections(
                    numericFilters = listOf("id=$id"),
                    page = 0,
                    hitsPerPage = 1
            )
                    .map { it.results }
                    .map { it.first() }
}