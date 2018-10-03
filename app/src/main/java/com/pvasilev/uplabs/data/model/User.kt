package com.pvasilev.uplabs.data.model

import com.squareup.moshi.Json

data class User(
        val id: Int,
        val nickname: String,
        @Json(name = "full_name") val fullName: String,
        val headline: String?,
        @Json(name = "avatar_url") val avatar: String,
        @Json(name = "followers_count") val followers: Int,
        @Json(name = "following_count") val following: Int
)