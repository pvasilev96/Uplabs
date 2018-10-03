package com.pvasilev.uplabs.di.provider

import com.pvasilev.uplabs.data.api.UplabsApi
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Provider

class UplabsApiProvider @Inject constructor(private val retrofit: Retrofit) : Provider<UplabsApi> {
    override fun get(): UplabsApi = retrofit.create(UplabsApi::class.java)
}