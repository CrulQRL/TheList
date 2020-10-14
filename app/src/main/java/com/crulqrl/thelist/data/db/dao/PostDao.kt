package com.crulqrl.thelist.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.crulqrl.thelist.data.db.table.Post

@Dao
interface PostDao {
    @Query("SELECT * FROM post_table")
    suspend fun getPosts(): List<Post>

    @Query("SELECT * FROM post_table WHERE title LIKE :query")
    suspend fun searchPostByTitle(query: String): List<Post>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(post: Post)

    @Query("DELETE FROM post_table")
    suspend fun deleteAll()
}