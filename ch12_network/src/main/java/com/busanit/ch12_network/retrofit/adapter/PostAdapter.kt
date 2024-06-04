package com.busanit.ch12_network.retrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.busanit.ch12_network.databinding.ItemPostBinding
import com.busanit.ch12_network.retrofit.Post


// 4. 아이템을 리싸이클러뷰 어뎁터
class PostAdapter(val posts: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root){

        // 항목 뷰에 데이터를 바인딩
        fun bind(post: Post) {
            binding.titleTextView.text = post.title
            binding.bodyTextView.text = post.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        // XML 레이아웃을 인플레이트하여 뷰홀더 객체의 매개변수로 넣어 뷰홀더를 생성 반환
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    // 전체 데이터 사이즈
    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        // 주어진 위치의 Post 객체를 뷰홀더에 바인딩
        holder.bind(posts[position])
    }
}