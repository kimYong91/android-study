package com.busanit.ex01

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ex01.databinding.ActivityMainBinding

/*
#### 연습문제 : 인텐트를 사용하여 데이터 전달하기

요구사항:

1. `MainActivity`와 `SecondActivity`를 생성합니다.
2. `MainActivity`에 `EditText`와 `Button`을 추가합니다.
3. `Button`을 클릭하면 `EditText`에 입력된 텍스트를 `SecondActivity`로 전달하고, `SecondActivity`에서 전달받은 텍스트를 `TextView`에 표시합니다.
4. `SecondActivity`에서 버튼을 추가하여, 버튼을 클릭하면 `MainActivity`로 돌아가도록 합니다.

힌트:

- 인텐트로 데이터 전달: `intent.putExtra("key", value)`
- 데이터 수신: `intent.getStringExtra("key")`

---

#### 연습문제 : 인텐트로 결과 반환받기

요구사항:

1. `MainActivity`와 `SecondActivity`를 생성합니다.
2. `MainActivity`에 `Button`을 추가하여, 버튼을 클릭하면 `SecondActivity`를 시작합니다.
3. `SecondActivity`에 `EditText`와 `Button`을 추가합니다.
4. `SecondActivity`에서 버튼을 클릭하면, `EditText`에 입력된 텍스트를 결과로 `MainActivity`에 반환합니다.
5. `MainActivity`는 `onActivityResult` 메서드를 오버라이드하여, `SecondActivity`로부터 반환된 결과를 `TextView`에 표시합니다.

힌트:

- 인텐트 시작: `startActivityForResult(intent, requestCode)`
- 결과 설정: `setResult(Activity.RESULT_OK, intent)`
- 결과 처리: `onActivityResult(requestCode, resultCode, data)`
 */
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val REQUEST_CODE = 30
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {

            // 문제1 데이터 전달
            button.setOnClickListener {
                val intent = Intent(this@MainActivity, SecondActivity::class.java).apply {
                    val msg = editText.text.toString()
                    putExtra("msg", msg)
                }

                startActivity(intent)
            }

            // 문제2. 데이터 전달
            button2.setOnClickListener {
                val intent = Intent(this@MainActivity, SecondActivity::class.java).apply {
                    val msg = editText.text.toString()
                    putExtra("msg", msg)
                }

                startActivityForResult(intent, REQUEST_CODE)
            }


            // 문제3. Result API
            val contract = ActivityResultContracts.StartActivityForResult()
            val launcher = registerForActivityResult(contract) {
                if (it.resultCode == RESULT_OK) {
                    val returnMsg = it.data?.getStringExtra("return_msg")
                    binding.textView.text = returnMsg
                }
            }


            button3.setOnClickListener {
                val intent = Intent(this@MainActivity, SecondActivity::class.java).apply {
                    val msg = editText.text.toString()
                    putExtra("msg", msg)
                }

                launcher.launch(intent)
            }
        }

    }

    // 문제2
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE -> {
                    binding.textView.text = data?.getStringExtra("return_msg")
                }
            }
        }
    }
}