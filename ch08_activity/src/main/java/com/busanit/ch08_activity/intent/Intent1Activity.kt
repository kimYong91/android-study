package com.busanit.ch08_activity.intent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ch08_activity.databinding.ActivityIntent1Binding

class Intent1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityIntent1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Intent로부터 데이터를 가져옴
        val extra1 = intent.getStringExtra("Extra1")
                                            // 문자열, 기본값 null

        val extra2 = intent.getIntExtra("Extra2", 0)

        binding.textView.text = extra1
    }
}