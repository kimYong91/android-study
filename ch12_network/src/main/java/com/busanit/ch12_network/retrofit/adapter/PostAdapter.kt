package com.busanit.ch12_network.retrofit.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.busanit.ch12_network.databinding.ItemPostBinding
import com.busanit.ch12_network.retrofit.activity.CommentActivity
import com.busanit.ch12_network.retrofit.model.Post


// 4. 아이템을 리싸이클러뷰 어뎁터
class PostAdapter(val posts: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root){

        // 항목 뷰에 데이터를 바인딩
        fun bind(post: Post) {
            binding.titleTextView.text = post.title
            binding.bodyTextView.text = post.body
            // 항목을 클릭했을 때 댓글을 액티비티로 시작하고 데이터 전달
            binding.root.setOnClickListener{
                // 컨텍스트 추출
                val context = it.context
                val intent = Intent(context, CommentActivity::class.java)
                intent.putExtra("postId", post.id)
                context.startActivity(intent)
            }
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