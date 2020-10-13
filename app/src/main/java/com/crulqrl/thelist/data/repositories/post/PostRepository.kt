package com.crulqrl.thelist.data.repositories.post

import com.crulqrl.thelist.data.entities.Post
import javax.inject.Inject

class PostRepository @Inject constructor(private val postRemoteDataSource: PostRemoteDataSource) {

    suspend fun getPosts(): ArrayList<Post> {
        return postRemoteDataSource.getPosts()
    }

}