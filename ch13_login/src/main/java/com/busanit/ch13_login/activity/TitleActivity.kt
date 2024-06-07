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

            val token = getToken()

            // 토큰이 없는 경우 타이틀 화면 진행
            if (token.isNullOrEmpty()) {
                // 로그인 버튼 클릭시 LoginActivity 로 화면 이동
                binding.buttonLogin.setOnClickListener {
                    startActivity(Intent(this, LoginActivity::class.java))
                }

                // 회원가입 버튼 클릭시 RegisterActivity 로 화면 이동
                binding.buttonRegister.setOnClickListener {
                    startActivity(Intent(this, RegisterActivity::class.java))
                }
            } else {
                // 토큰이 존재하면 MainActivity로 이동
                startActivity(Intent(this, MainActivity::class.java))
                finish()    //
            }


    }

    // sharedPreferences 에서 토큰 가져오는 함수
    private fun getToken(): String {
        val sharedPreferences = getSharedPreferences("app_pref", MODE_PRIVATE)
        return sharedPreferences.getString("token", null) ?: ""
    }
}