package com.pvasilev.uplabs.data.model

import com.squareup.moshi.Json

data class Collection(
        val id: Int,
        val name: String,
        val description: String,
        @Json(name = "post_ids") val postIds: List<Int>,
        @Json(name = "user") val author: User
)