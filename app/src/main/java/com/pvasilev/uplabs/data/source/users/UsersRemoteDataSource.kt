package com.pvasilev.uplabs.data.source.users

import com.pvasilev.uplabs.data.api.UplabsApi
import com.pvasilev.uplabs.data.model.User
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class UsersRemoteDataSource @Inject constructor(private val api: UplabsApi) : UsersDataSource {
    override fun getFollowers(nickname: String): Single<List<User>> = api.getFollowers(nickname)

    override fun getFollowing(nickname: String): Single<List<User>> = api.getFollowing(nickname)

    override fun follow(nickname: String): Completable = api.follow(nickname)

    override fun unfollow(nickname: String): Completable = api.unfollow(nickname)
}