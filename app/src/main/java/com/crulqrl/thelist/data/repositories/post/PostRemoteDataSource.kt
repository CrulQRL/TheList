package com.crulqrl.thelist.data.repositories.post

import com.crulqrl.thelist.data.api.PostApi
import com.crulqrl.thelist.data.db.table.Post
import javax.inject.Inject

class PostRemoteDataSource @Inject constructor(private val postApi: PostApi) {

    suspend fun getPosts(): ArrayList<Post> {
        return postApi.getPosts()
    }

}