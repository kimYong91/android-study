package com.busanit.ch12_network.glide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.busanit.ch12_network.R
import com.busanit.ch12_network.databinding.ActivityGlideBinding

class GlideActivity : AppCompatActivity() {
    lateinit var binding: ActivityGlideBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGlideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 고양이 관련 랜텀 이미지 URL
        val imageUrl = "https://loremflickr.com/600/400"

        // Glide 사용해서 현재 Activity에서 이미지를 로드
        Glide.with(this)
            .load(imageUrl)     // 불러올 이미지 URL
            .into(binding.imageView)    // 표시할 이미지 뷰

        Glide.with(this)
            .load(imageUrl)
            .placeholder(R.drawable.placeholder)  // 이미지가 로드중일 때 이미지
            .error(R.drawable.error)      // 에러가 났을 때 이미지
            .circleCrop()    // 이미지 원형으로 변환 옵션
            .override(100, 100)    // 이미지 크기 조정
            .centerCrop()   // 중간에서 자르기
            .fitCenter()    // 가운데서 맞추기
            .into(binding.imageView2)

        // GIF 이미지 로드
        Glide.with(this)
            .asGif()
            .load("https://media.giphy.com/media/aFTt8wvDtqKCQ/giphy.gif")
            .into(binding.imageView)
    }
}