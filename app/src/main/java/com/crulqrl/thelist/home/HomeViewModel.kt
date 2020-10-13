package com.crulqrl.thelist.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel: ViewModel() {

    init {

        getPosts()
    }

    private fun getPosts() {
//        if (getAddressFormJob?.isActive == true) {
//            return
//        }
//        getAddressFormJob = launchGetAddressForm()
        launchGetPosts()
    }

    private fun launchGetPosts(): Job {
        return viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
//                showProgress.value = true
            }
        }
    }

}