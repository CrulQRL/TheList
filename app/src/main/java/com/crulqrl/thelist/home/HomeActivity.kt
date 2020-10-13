package com.crulqrl.thelist.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.crulqrl.thelist.R
import com.crulqrl.thelist.data.entities.Post
import com.crulqrl.thelist.home.adapter.PostsAdapter
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    private lateinit var postsAdapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRv()
    }

    fun initRv() {
        val linearLayout = LinearLayoutManager(this)
        rv_home.layoutManager = linearLayout
        val p1 = Post(
            "1",
            1,
            "Hehe asdfj a aeh as ",
            ""
        )
        val p2 = Post(
            "1",
            1,
            "Hehe asdfj a aeh as asldkfjaldskjflkasjdflkasjdflkjsdlfjlkdfjas",
            ""
        )
        val p3 = Post(
            "1",
            1,
            "Hehe asdfj a aeh as ",
            ""
        )
        val p4 = Post(
            "1",
            1,
            "Hehe asdfj a aeh as  dalsfjas dfljaslfd lasldkfjlsadjflsajkdflksadjflskajdflasjdflkj",
            ""
        )
        val p5 = Post(
            "1",
            1,
            "Hehe asdfj a aeh as ",
            ""
        )
        postsAdapter = PostsAdapter(arrayListOf(p1, p2, p3, p4, p5))
        rv_home.adapter = postsAdapter
    }
}