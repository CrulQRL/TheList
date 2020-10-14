package com.crulqrl.thelist.data.repositories.post

import com.crulqrl.thelist.data.api.PostApi
import com.crulqrl.thelist.data.api.Result
import com.crulqrl.thelist.data.db.table.Post
import com.crulqrl.thelist.util.safeApiCall
import javax.inject.Inject

class PostRemoteDataSource @Inject constructor(private val postApi: PostApi) {

    suspend fun getPosts(): Result<ArrayList<Post>> {
        return safeApiCall { postApi.getPosts() }
    }

}