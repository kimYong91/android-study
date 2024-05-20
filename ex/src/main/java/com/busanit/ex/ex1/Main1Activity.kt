package com.busanit.ex.ex1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ex.databinding.ActivityMain1Binding

class Main1Activity : AppCompatActivity() {
    lateinit var binding: ActivityMain1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain1Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.run {

            sendButton.setOnClickListener {
                val intent = Intent(this@Main1Activity, Second1Activity::class.java)

                intent.putExtra("Key", editText.text.toString())

                if (!editText.text.toString().isEmpty()) {
                    startActivity(intent)
                } else {
                    Toast.makeText(this@Main1Activity, "글자를 입력하세요", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

/*
#### 연습문제 : 인텐트를 사용하여 데이터 전달하기

요구사항:

1. `MainActivity`와 `SecondActivity`를 생성합니다.

2. `MainActivity`에 `EditText`와 `Button`을 추가합니다.

3. `Button`을 클릭하면 `EditText`에 입력된 텍스트를
`SecondActivity`로 전달하고, `SecondActivity`에서 전달받은 텍스트를 `TextView`에 표시합니다.

4. `SecondActivity`에서 버튼을 추가하여, 버튼을 클릭하면 `MainActivity`로 돌아가도록 합니다.

힌트:

- 인텐트로 데이터 전달: `intent.putExtra("key", value)`
- 데이터 수신: `intent.getStringExtra("key")`
 */