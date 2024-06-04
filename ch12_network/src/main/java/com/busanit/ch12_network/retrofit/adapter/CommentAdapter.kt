package com.busanit.ch12_network.retrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.busanit.ch12_network.databinding.ItemCommentBinding
import com.busanit.ch12_network.retrofit.model.Comment


class CommentAdapter(val comments: List<Comment>) : RecyclerView.Adapter<CommentAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: ItemCommentBinding) : RecyclerView.ViewHolder(binding.root){

        // 항목 뷰에 데이터를 바인딩
        fun bind(comment: Comment) {
           binding.run {
               nameTextView.text = comment.name
               emailTextView.text = comment.email
               bodyTextView.text = comment.body
           }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // XML 레이아웃을 인플레이트하여 뷰홀더 객체의 매개변수로 넣어 뷰홀더를 생성 반환
        val binding = ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    // 전체 데이터 사이즈
    override fun getItemCount(): Int = comments.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // 주어진 위치의 데이터 객체를 뷰홀더에 바인딩
        holder.bind(comments[position])
    }
}