package com.pvasilev.uplabs.data.api

import com.pvasilev.uplabs.data.model.User
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface UplabsApi {
    @GET("users/{nickname}/followers.json")
    fun getFollowers(@Path("nickname") nickname: String): Single<List<User>>

    @GET("users/{nickname}/followings.json")
    fun getFollowing(@Path("nickname") nickname: String): Single<List<User>>

    @PUT("users/{nickname}/follow")
    fun follow(@Path("nickname") nickname: String): Completable

    @PUT("users/{nickname}/unfollow")
    fun unfollow(@Path("nickname") nickname: String): Completable

    @PUT("posts/{postId}/upvote")
    fun upvote(@Path("postId") postId: String): Completable

    @PUT("posts/{postId}/downvote")
    fun downvote(@Path("postId") postId: String): Completable
}