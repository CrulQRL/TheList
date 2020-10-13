package com.crulqrl.thelist.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crulqrl.thelist.data.api.PostApi
import com.crulqrl.thelist.data.entities.Post
import com.crulqrl.thelist.data.repositories.post.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {

    private var getPostsJob: Job? = null
    val posts = MutableLiveData<ArrayList<Post>>()
    val showProgress = MutableLiveData<Boolean>()

    init {
        getPosts()
    }

    private fun getPosts() {
        if (getPostsJob?.isActive == true) {
            return
        }
        getPostsJob = launchGetPosts()
    }

    private fun launchGetPosts(): Job {
        return viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                showProgress.value = true
            }
            val result = postRepository.getPosts()
            withContext(Dispatchers.Main) {
                posts.value = result
                showProgress.value = false
            }
        }
    }

}