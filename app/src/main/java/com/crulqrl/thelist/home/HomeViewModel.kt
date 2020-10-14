package com.crulqrl.thelist.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crulqrl.thelist.data.api.Result
import com.crulqrl.thelist.data.db.table.Post
import com.crulqrl.thelist.data.repositories.post.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {

    private var getPostsJob: Job? = null
    val posts = MutableLiveData<List<Post>>()
    val showProgress = MutableLiveData<Boolean>()
    val showError = MutableLiveData<String>()

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

                when(result) {
                    is Result.Success<ArrayList<Post>> -> {
                        posts.value = result.data
                    }
                    is Result.Error -> {
                        showError.value = "Oopss, something went wrong"
                    }
                }

                showProgress.value = false
            }
        }
    }

    fun searchTitle(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                showProgress.value = true
            }
            val result = postRepository.searchTitle(query)
            withContext(Dispatchers.Main) {
                posts.value = result
                showProgress.value = false
            }
        }
    }

}