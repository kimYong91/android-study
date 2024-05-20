package com.busanit.ex01

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ex01.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            val msg = intent.getStringExtra("msg")
            textView.text = msg

            returnButton.setOnClickListener {
                val returnMsg = editText.text.toString()

                val returnIntent = Intent().apply {
                    putExtra("return_msg", returnMsg)
                }
                setResult(RESULT_OK, returnIntent)

                finish()
            }
        }
    }
}