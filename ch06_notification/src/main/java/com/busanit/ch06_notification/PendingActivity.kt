package com.busanit.ch06_notification

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.TaskStackBuilder
import androidx.core.content.ContextCompat
import com.busanit.ch06_notification.databinding.ActivityPendingBinding

class PendingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPendingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. 권한 획득
        // 권한 요청을 위한 Launcher 등록
        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                // 권한이 허용되었으면 알람
                notification()
            } else {
                // 거부되었으면 토스트
                Toast.makeText(this, "권한이 거부되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        // 버튼 클릭 리스너
        binding.button.setOnClickListener {
            // 알림 권한이 있는지 체크
            if (ContextCompat.checkSelfPermission(
                    this, Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                // 권한 허용된 경우 알림 표시
                notification()
            } else {
                // 권한이 허용되지 않은 경우 권한 허용을 요청
                permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }

        // 2. 채널 생성
        createNotificationChannel("ch2", "채널2번")

        // 3. 알림 빌드
        // 4. notify 메서드 실행
    }

    fun notification() {
        // 알림 Builder로 빌드하기
        val builder = getNotificationBuilder("ch2")
        builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
            .setContentTitle("알림 제목입니다.")
            .setContentText("알림의 내용입니다.")

        // 메시지를 터치하면 다른 Activity를 실행하는 Intent 객체를 만듭니다.
        val intent = Intent(this@PendingActivity, testActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        // 인텐트에 데이터를 넣어 전달
        intent.putExtra("msg", "알림을 터치하셨습니다.")
        intent.putExtra("data", "데이터")

        /* pendingIntent : 알림을 클릭했을때 애플리케이션의 특정 Activity 실행시키는 메시지
           - FLAG_ACTIVITY_NEW_TASK : 새로운 작업 스택 생성 플래그
           - FLAG_ACTIVITY_CLEAR_TASK : 기존 작업 지우는 플래그
           - PendingIntent.FLAG_UPDATE_CURRENT : 기존 펜딩 인텐트 업데이트 플래그
           - PendingIntent.FLAG_IMMUTABLE : 기존 펜딩 인텐트 변경 불가 플래그
           TaskStackBuilder : 인텐트를 스택으로 쌓는 빌더
        */

        // pendingIntent를 생성합니다.
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent) // 인텐트를 스택에 추가합니다.
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        }

        builder.setContentIntent(pendingIntent) // 알림 클릭시 실행할 인텐트 설정

        val notification = builder.build()

        // 알림 매니저 가져오기
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        // 알림 표시
        notificationManager.notify(22, notification)
    }

    // 알림 Builder 객체를 생성하는 메서드
    fun getNotificationBuilder(id: String): NotificationCompat.Builder {
        // 26버전 이상일 때는 Builder에 채널ID 추가
        lateinit var builder: NotificationCompat.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = NotificationCompat.Builder(this, id)
        } else {
            builder = NotificationCompat.Builder(this)
        }
        return builder
    }

    // 채널을 생성하고 등록하는 함수
    fun createNotificationChannel(id: String, name: String) {
        // 26버전 이상일 때만 채널 생성
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // id : 채널 ID - 코드에서 채널을 관리하기 위한 이름
            // name : 채널 이름 - 사용자에게 노출시킬 이름
            val importance = NotificationManager.IMPORTANCE_HIGH // 중요도
            val desc = "채널에 대한 설명"

            val channel =
                NotificationChannel(id, name, importance).apply {
                    description = desc
                    enableLights(true)  // 단말기에 LED 램프가 있다면 사용하기로 설정
                    lightColor = Color.RED    // LED 램프의 색상을 설정
                    enableVibration(true)   // 진동 사용 여부 설정
                    vibrationPattern = longArrayOf(100, 200, 300, 400)  // 진동 패턴
                }

            // 시스템 서비스에서 알림 관리자 객체 가져오기
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            // 알림 관리자에서 채널을 등록
            manager.createNotificationChannel(channel)
        } else {
            // 26버전 이하에는 채널 필요 없음
        }
    }
}