package com.pvasilev.uplabs.di.provider

import com.pvasilev.uplabs.data.api.AlgoliaApi
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Provider

class AlgoliaApiProvider @Inject constructor(private val retrofit: Retrofit) : Provider<AlgoliaApi> {
    override fun get(): AlgoliaApi = retrofit.create(AlgoliaApi::class.java)
}