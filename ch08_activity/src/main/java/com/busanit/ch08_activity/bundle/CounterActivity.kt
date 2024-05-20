package com.busanit.ch08_activity.bundle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ch08_activity.databinding.ActivityCounterBinding

class CounterActivity : AppCompatActivity() {
    lateinit var binding: ActivityCounterBinding
    var count = 0
    // 액티비티가 생성될 때 savedInstanceState가 매개변수로 전달됨
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.countButton.setOnClickListener {
            count++
            binding.textView.text = "$count"
        }
    }

    // 액티비티가 일시적으로 소멸될 때
    // Bundle 객체에 임시 상태 데이터를 지정할 수 있음.
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // 번들 객체에 필요한 데이터를 저장 "Key", "Value"
        outState.putInt("count", count)
    }

    // 액티비티가 재생성 될때 번들 객체 savedInstanceState 통해 복원 가능
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val saveData: Int = savedInstanceState.getInt("count")
        count = saveData
        binding.textView.text = "$saveData"
    }
}