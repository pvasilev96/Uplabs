package com.pvasilev.uplabs.di.provider

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import javax.inject.Inject
import javax.inject.Provider

class MoshiProvider @Inject constructor() : Provider<Moshi> {
    override fun get(): Moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
}