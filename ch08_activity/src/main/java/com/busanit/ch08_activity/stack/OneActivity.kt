package com.busanit.ch08_activity.stack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ch08_activity.databinding.ActivityOneBinding

class OneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            oneTextView1.setOnClickListener{
                startActivity(Intent(this@OneActivity, OneActivity::class.java))
            }
            oneTextView2.setOnClickListener{
                startActivity(Intent(this@OneActivity, TwoActivity::class.java))
            }
            oneTextView3.setOnClickListener{
                startActivity(Intent(this@OneActivity, ThreeActivity::class.java))
            }
        }

    }
}