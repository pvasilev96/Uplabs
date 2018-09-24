package com.pvasilev.uplabs.data.source.users

import com.pvasilev.uplabs.data.model.User
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class UsersRepository @Inject constructor(private val remoteDataSource: UsersRemoteDataSource) : UsersDataSource {
    override fun getFollowers(nickname: String): Single<List<User>> = remoteDataSource.getFollowers(nickname)

    override fun getFollowing(nickname: String): Single<List<User>> = remoteDataSource.getFollowing(nickname)

    override fun follow(nickname: String): Completable = remoteDataSource.follow(nickname)

    override fun unfollow(nickname: String): Completable = remoteDataSource.unfollow(nickname)
}