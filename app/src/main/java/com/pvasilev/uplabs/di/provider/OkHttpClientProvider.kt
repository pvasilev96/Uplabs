package com.pvasilev.uplabs.di.provider

import okhttp3.OkHttpClient
import javax.inject.Inject
import javax.inject.Provider

class OkHttpClientProvider @Inject constructor() : Provider<OkHttpClient> {
    override fun get(): OkHttpClient = OkHttpClient.Builder().build()
}