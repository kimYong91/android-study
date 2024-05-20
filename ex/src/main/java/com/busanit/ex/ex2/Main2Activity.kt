package com.busanit.ex.ex2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ex.databinding.ActivityMain2Binding

class Main2Activity : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nextButton.setOnClickListener {
            val intent = Intent(this, Second2Activity::class.java)
            startActivity(intent)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 5) {
            val result = data?.getStringExtra("Key")
            binding.textView.text = result
        }
    }
}
/*
#### 연습문제 : 인텐트로 결과 반환받기

요구사항:

1. `MainActivity`와 `SecondActivity`를 생성합니다.

2. `MainActivity`에 `Button`을 추가하여, 버튼을 클릭하면 `SecondActivity`를 시작합니다
.
3. `SecondActivity`에 `EditText`와 `Button`을 추가합니다.

4. `SecondActivity`에서 버튼을 클릭하면, `EditText`에
입력된 텍스트를 결과로 `MainActivity`에 반환합니다.

5. `MainActivity`는 `onActivityResult` 메서드를 오버라이드하여, `SecondActivity`로부터
반환된 결과를 `TextView`에 표시합니다.

힌트:

- 인텐트 시작: `startActivityForResult(intent, requestCode)`
- 결과 설정: `setResult(Activity.RESULT_OK, intent)`
- 결과 처리: `onActivityResult(requestCode, resultCode, data)`
 */