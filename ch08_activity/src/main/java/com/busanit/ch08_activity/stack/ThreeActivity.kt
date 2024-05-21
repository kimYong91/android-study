package com.busanit.ch08_activity.stack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ch08_activity.databinding.ActivityThreeBinding

class ThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.run {

            // FLAG_ACTIVITY_CLEAR_TOP : 지정된 액티비티가 이미 스택에 존재하면, 그 위의 모든 액티비티를 제거하고 지정한 액티비티를 최상단에 올림
            // 홈 화면으로 바로 돌아갈 때 사용
            threeTextView1.setOnClickListener{
                startActivity(Intent(this@ThreeActivity, OneActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                })
            }
            threeTextView2.setOnClickListener{
                startActivity(Intent(this@ThreeActivity, TwoActivity::class.java))
            }

            // FLAG_ACTIVITY_NEW_TASK : 새로운 테스크에서 액티비티를 시작, 브라우져나 외부 애플리케이션에서 액티비티를 시작할 때 사용
            threeTextView3.setOnClickListener{
                startActivity(Intent(this@ThreeActivity, ThreeActivity::class.java). apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                })
            }
        }
    }
}