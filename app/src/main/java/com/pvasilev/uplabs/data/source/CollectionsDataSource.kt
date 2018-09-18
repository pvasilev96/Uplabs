package com.pvasilev.uplabs.data.source

import com.pvasilev.uplabs.data.model.Collection
import io.reactivex.Single

interface CollectionsDataSource {
    fun getCollections(): Single<List<Collection>>

    fun getCollection(id: Int): Single<Collection>
}