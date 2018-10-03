package com.pvasilev.uplabs.di.module

import com.pvasilev.uplabs.data.api.AlgoliaApi
import com.pvasilev.uplabs.data.api.UplabsApi
import com.pvasilev.uplabs.di.provider.*
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import toothpick.config.Module

class NetworkModule : Module() {
    init {
        bind(Moshi::class.java).toProvider(MoshiProvider::class.java).providesSingletonInScope()
        bind(OkHttpClient::class.java).toProvider(OkHttpClientProvider::class.java).providesSingletonInScope()
        bind(Retrofit::class.java).toProvider(RetrofitProvider::class.java).providesSingletonInScope()
        bind(AlgoliaApi::class.java).toProvider(AlgoliaApiProvider::class.java).providesSingletonInScope()
        bind(UplabsApi::class.java).toProvider(UplabsApiProvider::class.java).providesSingletonInScope()
    }
}