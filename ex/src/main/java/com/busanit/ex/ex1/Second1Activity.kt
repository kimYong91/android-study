package com.busanit.ex.ex1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ex.databinding.ActivitySecond1Binding

class Second1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecond1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
            finish()
        }
        binding.run {
            val extra = intent.getStringExtra("Key")
            textView.text = extra
        }

    }
}