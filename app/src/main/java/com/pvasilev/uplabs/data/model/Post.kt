package com.pvasilev.uplabs.data.model

import com.squareup.moshi.Json

data class Post(
        val id: Int,
        @Json(name = "name") val title: String,
        val description: String,
        @Json(name = "teaser_url") val teaser: String,
        @Json(name = "link_url") val url: String,
        @Json(name = "serialized_submitter") val author: User,
        @Json(name = "category_friendly_name") val category: String,
        @Json(name = "subcategory_friendly_name") val subcategory: String,
        val points: Int,
        @Json(name = "view_count") val views: Int
)