package com.crulqrl.thelist.data.repositories.post

import com.crulqrl.thelist.data.db.table.Post
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val postRemoteDataSource: PostRemoteDataSource,
    private val postLocalDataSource: PostLocalDataSource
) {

    suspend fun getPosts(): ArrayList<Post> {
        val posts = postRemoteDataSource.getPosts()
        postLocalDataSource.insertAll(posts)
        return posts
    }

    suspend fun searchTitle(query: String): List<Post> {
        return postLocalDataSource.searchByTitle(query)
    }

}