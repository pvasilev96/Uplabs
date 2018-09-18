package com.pvasilev.uplabs.data.source

import com.pvasilev.uplabs.data.model.User
import io.reactivex.Single

interface UserDataSource {
    fun getUser(id: Int): Single<User>
}