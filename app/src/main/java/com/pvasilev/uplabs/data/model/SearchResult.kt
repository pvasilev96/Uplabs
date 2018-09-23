package com.pvasilev.uplabs.data.model

import com.squareup.moshi.Json

data class SearchResult<T>(
        @Json(name = "hits") val results: List<T>,
        @Json(name = "nbHits") val hits: Int,
        @Json(name = "nbPages") val pages: Int
)