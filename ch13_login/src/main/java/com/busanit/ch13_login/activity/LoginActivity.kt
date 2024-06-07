package com.busanit.ch13_login.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ch13_login.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}