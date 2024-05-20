package com.busanit.ex.ex2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ex.databinding.ActivitySecond2Binding

class Second2Activity : AppCompatActivity() {
    lateinit var binding: ActivitySecond2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecond2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            inputButton.setOnClickListener {
                val intent = Intent(this@Second2Activity, Main2Activity::class.java)
                    .apply {
                        putExtra("Key", editText.text.toString())
                    }
                startActivityForResult(intent, 5)
            }
        }

    }
}