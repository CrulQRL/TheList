package com.crulqrl.thelist.data.repositories.post

import com.crulqrl.thelist.data.api.Result
import com.crulqrl.thelist.data.db.table.Post
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val postRemoteDataSource: PostRemoteDataSource,
    private val postLocalDataSource: PostLocalDataSource
) {

    suspend fun getPosts(): Result<ArrayList<Post>> {
        val posts = postRemoteDataSource.getPosts()
        if (posts is Result.Success<ArrayList<Post>>) {
            postLocalDataSource.insertAll(posts.data)
        }

        return posts
    }

    suspend fun searchTitle(query: String): List<Post> {
        return postLocalDataSource.searchByTitle(query)
    }

}