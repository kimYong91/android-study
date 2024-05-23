package com.busanit.ch10_fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ch10_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // FragmentManager에서 Fragment를 추가
        supportFragmentManager.beginTransaction()       // 트렌젝션 시작
            .replace(R.id.fragment_container, SampleFragment())
            // 기본의 Fragment를 교체 (바꾸기전 컨테이너, 바꿀 프레그먼트
            .commit()   // 트렌젝션 커밋

    }
}