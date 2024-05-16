package com.busanit.ch05_dialog

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ch05_dialog.databinding.ActivityToastBinding
import com.busanit.ch05_dialog.databinding.CustomSnackbarBinding
import com.google.android.material.snackbar.Snackbar

class ToastActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    @RequiresApi(30)       // 하위 호환성 애너테이션의 경우 오류를 무시하기만 함.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityToastBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            // 토스트 메시지 띄우기
            // context, 메시지, 출력되는 시간
            // Toast.LENGTH_SHORT : 3초 정도
            // Toast.LENGTH_LONG : 5초 정도
            val toast = Toast.makeText(this, "일반 토스트 메시지입니다.", Toast.LENGTH_SHORT)
            toast.show()
        }

        binding.button2.setOnClickListener {
            // API 하위 호환성 고려하기
            // 1. 애너테이션 지정 2. IF문을 통해서 실행하기
            // 안드로이드 11버전부터 토스트 콜백 기능 추가
            // Build.VERSION_CODES.R 이것 대신 실제 버전의 숫자를 입력해도 됨
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val toast = Toast.makeText(this, "조금 긴 토스트 메시지 입니다.", Toast.LENGTH_LONG)

                // 토스트 객체가 나타나고 사라질 때 콜백 이벤트 추가
                toast.addCallback(object : Toast.Callback() {
                    override fun onToastShown() {
                        super.onToastShown()
                        Log.d("mylog", "토스트가 등장할 때 작동하는 콜백")
                    }

                    override fun onToastHidden() {
                        super.onToastHidden()
                        Log.d("mylog", "토스트가 사라질 때 작동하는 콜백")
                    }
                })
                toast.show()
            }
        }

        // 기존 스낵바
        binding.button3.setOnClickListener {
            Snackbar.make(it, "스낵바 메시지입니다.", Snackbar.LENGTH_SHORT).show()
        }

        // 액션 스낵바
        binding.button4.setOnClickListener {
            val snackBar = Snackbar.make(it, "액션을 취합니다.", Snackbar.LENGTH_LONG)

            snackBar.setTextColor(Color.YELLOW)         // 글자색
            snackBar.setBackgroundTint(Color.RED)       // 배경색
            snackBar.animationMode = Snackbar.ANIMATION_MODE_FADE   // 애니메이션

            // Action 설정 (기본적으로 한 번에 하나만 설정 가능)
            snackBar.setAction("OK") {
                binding.textView.text = "스낵바 ok를 눌렀습니다."
            }
            snackBar.show()
        }

        // 액션 스낵바 (액션 설정 두 개 이상 하는법, 커스텀 *레이아웃이 두개 이상 필요함)
        binding.button5.setOnClickListener {
            val snackbar = Snackbar.make(it, "", Snackbar.LENGTH_LONG)

            // 커스텀 스낵바 레이아웃 설정하기
            val snackbarBinding = CustomSnackbarBinding.inflate(layoutInflater)


            val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout
            snackbarLayout.addView(snackbarBinding.root)

            snackbarBinding.actionBtn1.setOnClickListener {
                binding.textView.text = "액션1 클릭"
            }

            snackbarBinding.actionBtn2.setOnClickListener {
                binding.textView.text = "액션2 클릭"
            }

            snackbar.show()
        }
    }

}