package com.crulqrl.thelist.data.repositories.post

import com.crulqrl.thelist.data.db.dao.PostDao
import com.crulqrl.thelist.data.db.table.Post
import javax.inject.Inject

class PostLocalDataSource @Inject constructor(private val postDao: PostDao) {

    suspend fun searchByTitle(query: String): List<Post> {
        return postDao.searchPostByTitle("%$query%")
    }

    suspend fun insertAll(posts: ArrayList<Post>) {
        posts.forEach {
            postDao.insert(it)
        }
    }

}