package com.crulqrl.thelist.data.api

import com.crulqrl.thelist.data.entities.Post
import retrofit2.http.GET
import retrofit2.http.POST

interface PostApi {
    @GET("posts/")
    suspend fun getPosts(): ArrayList<Post>
}