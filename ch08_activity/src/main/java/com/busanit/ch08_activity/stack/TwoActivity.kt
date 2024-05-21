package com.busanit.ch08_activity.stack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ch08_activity.databinding.ActivityTwoBinding

class TwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.run {
            twoTextView1.setOnClickListener{
                startActivity(Intent(this@TwoActivity, OneActivity::class.java))
            }
            twoTextView2.setOnClickListener{
                val intent = Intent(this@TwoActivity, TwoActivity::class.java)
                // SINGLE_TOP : 동일한 액티비티가 스택의 맨 위에 존재하면 기좀 인스턴스 재사용,
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)

                startActivity(intent)
            }
            twoTextView3.setOnClickListener{
                startActivity(Intent(this@TwoActivity, ThreeActivity::class.java))
            }
        }
    }
}