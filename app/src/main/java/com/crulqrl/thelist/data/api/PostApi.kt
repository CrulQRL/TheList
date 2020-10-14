package com.crulqrl.thelist.data.api

import com.crulqrl.thelist.data.db.table.Post
import retrofit2.http.GET

interface PostApi {
    @GET("posts/")
    suspend fun getPosts(): ArrayList<Post>
}