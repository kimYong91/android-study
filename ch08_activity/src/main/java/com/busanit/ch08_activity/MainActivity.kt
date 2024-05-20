package com.busanit.ch08_activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ch08_activity.databinding.ActivityMainBinding
import com.busanit.ch08_activity.intent.Intent1Activity
import com.busanit.ch08_activity.intent.Intent2Activity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding       // 지연초기화 바인딩 객체 선언
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 명시적 인텐트 사용
        binding.run {
            button1.setOnClickListener {
                // 첫번째 매개변수(출발 컨텍스트) : Context, 두번째 매개변수(도착 컨텍스트) : Acitivity 클래스 리플렉션
                // 버튼 클릭 자체는 액션액티비티가 아님
                val intent = Intent(this@MainActivity, Intent1Activity::class.java)
                // Context에서 액티비티를 시작
                startActivity(intent)
            }
            
            // 암시적 인텐트 사용
            button2.setOnClickListener {
                // 첫번째 매개변수 : Action, 두번째 매개변수 URI
                val uri = Uri.parse("https://www.naver.com")
                val intent = Intent(Intent.ACTION_VIEW, uri)

                // URI로 브라우저 열기
                startActivity(intent)
            }

            button3.setOnClickListener {
                val phoneNumber = "tel:01012345678"
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber))

                startActivity(intent)
            }

            button4.setOnClickListener {
                val phoneNumber = "sms:01012345678"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(phoneNumber))
                intent.putExtra("sms_body", "Hello! Message~!")
                startActivity(intent)
            }

            button5.setOnClickListener {
                // 인텐트로 공유 기능 사용
                // 인텐트 객체 생성하고 apply 스콥 함수 속성 설정
                val intent = Intent().apply {
                    // Action 설정 : 데이터를 다른 앱으로 보내는 액션
                    action = Intent.ACTION_SEND
                    // 인텐트에 데이터를 추가
                    putExtra(Intent.EXTRA_TEXT, "공유 메시지 텍스트")
                    type = "text/plain"     // 데이터 타입 설정
                }
                // createChooser 메서드 : 사용자에게 앱 선택 창을 표시하는 새로운 인텐트
                // 첫번째 매개변수 공유할 인텐트, 두번째 인자는 제목
                val shareIntent = Intent.createChooser(intent, null)
                startActivity(shareIntent)
            }

            button6.setOnClickListener {
                val intent = Intent(this@MainActivity, Intent1Activity::class.java)
                intent.putExtra("Extra1", "보내는 문자열")
                intent.putExtra("Extra2", 100)

                startActivity(intent)
            }

            button7.setOnClickListener {
                val intent = Intent(this@MainActivity, Intent2Activity::class.java)
                    .apply {
                        putExtra("extra_msg", "Hello")
                    }

                // 해당 액티비티를 시작하고 결과를 요청
                // 두번째 매개변수 : 요청코드
                startActivityForResult(intent, 10)
            }
        }
    }

    // 액티비티의 결과가 돌아왔을 때 수행되는 메서드
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // requestCode : 요청한 요청코드
        // resultCode : 결과 코드
        // data : 결과로 설정된 Intent 객체


        // 요청코드와 결과 코드가 맞을 때
        if (requestCode == 10 && resultCode == RESULT_OK) {
            // 인텐트 객체에서 데이터를 가져옴
            val result = data?.getStringExtra("result_msg")
            binding.textView.text = result
        }
    }
}