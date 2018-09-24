package com.pvasilev.uplabs.data.source.users

import com.pvasilev.uplabs.data.model.User
import io.reactivex.Completable
import io.reactivex.Single

interface UsersDataSource {
    fun getFollowers(nickname: String): Single<List<User>>

    fun getFollowing(nickname: String): Single<List<User>>

    fun follow(nickname: String): Completable

    fun unfollow(nickname: String): Completable
}