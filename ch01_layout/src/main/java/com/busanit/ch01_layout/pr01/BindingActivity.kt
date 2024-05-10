package com.busanit.ch01_layout.pr01

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ch01_layout.databinding.ActivityBindingBinding


class BindingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩 객체 획득
        val binding = ActivityBindingBinding.inflate(layoutInflater)

        // 바인딩 객체로 화면을 출력
        setContentView(binding.root)

        // findViewById를 사용하지 않고 뷰 객체 사용
        binding.visibleButton.setOnClickListener {
            binding.targetView.visibility = View.VISIBLE
        }

        binding.invisibleButton.setOnClickListener {
            binding.targetView.visibility = View.INVISIBLE
        }


        /* 여러 가지를 만들어야하는 경우 위의 방법으로 해야함
        val invisibleButton = findViewById<Button>(R.id.invisibleButton)
        val visibleButton = findViewById<Button>(R.id.visibleButton)
        val targetView = findViewById<TextView>(R.id.targetView)
         */

    }
}