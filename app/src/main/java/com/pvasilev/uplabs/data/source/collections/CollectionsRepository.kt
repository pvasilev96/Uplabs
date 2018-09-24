package com.pvasilev.uplabs.data.source.collections

import com.pvasilev.uplabs.data.model.Collection
import io.reactivex.Single
import javax.inject.Inject

class CollectionsRepository @Inject constructor(private val remoteDataSource: CollectionsRemoteDataSource) : CollectionsDataSource {
    override fun getCollections(page: Int): Single<List<Collection>> = remoteDataSource.getCollections(page)

    override fun getCollection(id: Int): Single<Collection> = remoteDataSource.getCollection(id)

}