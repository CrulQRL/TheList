package com.crulqrl.thelist.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.crulqrl.thelist.R
import com.crulqrl.thelist.data.db.table.Post
import kotlinx.android.synthetic.main.item_post.view.*

class PostsAdapter(
    private val posts: ArrayList<Post>
) : RecyclerView.Adapter<PostsAdapter.PostItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostItemHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostItemHolder, position: Int) {
        holder.bind(posts[position])
    }

    fun submitList(newPost: List<Post>) {
        posts.clear()
        posts.addAll(newPost)
        notifyDataSetChanged()
    }

    class PostItemHolder(private val view: View): RecyclerView.ViewHolder(view) {

        private lateinit var post: Post

        fun bind(post: Post) {
            this.post = post
            view.txt_item_post_title.text = this.post.title
        }

    }

}