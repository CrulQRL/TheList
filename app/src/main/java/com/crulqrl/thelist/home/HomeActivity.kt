package com.crulqrl.thelist.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.crulqrl.thelist.R
import com.crulqrl.thelist.common.ui.onTextChanged
import com.crulqrl.thelist.data.api.PostApi
import com.crulqrl.thelist.home.adapter.PostsAdapter
import com.crulqrl.thelist.inject.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {

    lateinit var postsAdapter: PostsAdapter
    @Inject
    lateinit var postApi: PostApi
    @Inject
    lateinit var providerFactory: ViewModelProviderFactory
    private val viewModel by lazy {
        ViewModelProvider(this, providerFactory).get(HomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observe()
        initSearch()
        initRv()
    }

    private fun observe() {
       viewModel.posts.observe(this) {
           postsAdapter.submitList(it)
       }

        viewModel.showProgress.observe(this) {
            progress_home.visibility = if (it) View.VISIBLE else View.GONE
        }
    }

    private fun initSearch() {
        edit_search.onTextChanged(500, lifecycle) {
            viewModel.searchTitle(it.toString())
        }
    }

    private fun initRv() {
        val linearLayout = LinearLayoutManager(this)
        rv_home.layoutManager = linearLayout
        postsAdapter = PostsAdapter(arrayListOf())
        rv_home.adapter = postsAdapter
    }
}