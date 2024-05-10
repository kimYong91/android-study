package com.busanit.ch01_layout.pr01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ch01_layout.R

class Tset2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 화면에 출력될 레이아웃 xml을 매개변수에 명시
        setContentView(R.layout.activity_tset2)

    }
}