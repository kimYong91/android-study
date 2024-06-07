package com.busanit.ch13_login.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ch13_login.databinding.ActivityTitleBinding

class TitleActivity : AppCompatActivity() {
    lateinit var binding: ActivityTitleBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityTitleBinding.inflate(layoutInflater)
            setContentView(binding.root)

            // 로그인 버튼 클릭시 LoginActivity 로 화면 이동
            binding.buttonLogin.setOnClickListener {
                startActivity(Intent(this, LoginActivity::class.java))
            }

            // 회원가입 버튼 클릭시 RegisterActivity 로 화면 이동
            binding.buttonRegister.setOnClickListener {
                startActivity(Intent(this, RegisterActivity::class.java))
            }



    }
}