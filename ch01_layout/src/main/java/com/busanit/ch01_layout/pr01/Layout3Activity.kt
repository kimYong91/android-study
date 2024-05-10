package com.busanit.ch01_layout.pr01

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ch01_layout.R

class Layout3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout3)

        val btn1 = findViewById<Button>(R.id.button1)
        val btn2 = findViewById<Button>(R.id.button2)
        val btn3 = findViewById<Button>(R.id.button3)
        val btn4 = findViewById<Button>(R.id.button4)

        btn1.setOnClickListener {
            btn4.visibility = View.VISIBLE
        }
        btn2.setOnClickListener {
            btn4.visibility = View.INVISIBLE
        }
        btn3.setOnClickListener {
            btn4.visibility = View.GONE
        }
    }
}