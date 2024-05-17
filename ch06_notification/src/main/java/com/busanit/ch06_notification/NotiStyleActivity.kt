package com.busanit.ch06_notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.Person
import androidx.core.graphics.drawable.IconCompat
import com.busanit.ch06_notification.databinding.ActivityNotiStyleBinding
import kotlin.concurrent.thread

class NotiStyleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityNotiStyleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 채널 생성
        createNotificationChannel("ch3", "채널3")

        binding.button1.setOnClickListener {
            // 빌더 설정
            val builder = getNotificationBuilder("ch3")

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
                .setContentTitle("프로그레스 바")
                // 진행상태 설정 (최대진행값, 현재진행상태, 진행률의 불확정상태 여부)
                .setProgress(100, 0, false)

            // 새로운 스레드에서 100 밀리초마다 진행상태 업데이트
            thread {
                for (i in 1..100) {
                    builder.setProgress(100, i, false)
                    notificationManager.notify(44, builder.build())
                    SystemClock.sleep(100)
                }
            }

            notificationManager.notify(44, builder.build())
        }

        binding.button2.setOnClickListener {
            val builder = getNotificationBuilder("ch3")

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            // 이미지 파일 비트맵으로 준비
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.android)

            builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
                .setContentTitle("큰 이미지 설정하기")
                .setLargeIcon(bitmap)
                // 보여줄 이미지를 설정
                .setStyle(
                    // 알람 큰 그림
                    NotificationCompat.BigPictureStyle()
                        .bigPicture(bitmap)
                )

            notificationManager.notify(40, builder.build())
        }

        binding.button3.setOnClickListener {
            val builder = getNotificationBuilder("ch3")

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            // 알림을 펼쳤을 때 장문의 문자열을 보여주는 스타일
            builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
                .setContentTitle("긴 텍스트 스타일 설정")
                .setStyle(
                    NotificationCompat.BigTextStyle()
                        .bigText(getString(R.string.long_text))
                )

            notificationManager.notify(50, builder.build())
        }

        binding.button4.setOnClickListener {
            val builder = getNotificationBuilder("ch3")

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            // 알림을 펼쳤을 때 받은 편지함 스타일 (최대 6줄)
            builder
                .setSmallIcon(android.R.drawable.ic_notification_overlay)
                .setContentTitle("받은 편지함 스타일 설정")
                .setStyle(
                    NotificationCompat.InboxStyle()
                        .addLine("안녕하세요")
                        .addLine("Re: 반갑습니다")
                        .addLine("[광고] 반드시 보세요!")
                        .addLine("답장입니다")
                        .addLine("오늘의 할일")
                        .setSummaryText("요약 텍스트")
                        .setBigContentTitle("컨텐츠 제목")
                )

            notificationManager.notify(50, builder.build())
        }

        binding.button5.setOnClickListener {
            val builder = getNotificationBuilder("ch3")

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            // 메시지 화면을 위해 Person 객체 생성

            val person1 = Person.Builder()
                .setIcon(IconCompat.createWithResource(this, R.drawable.person1))
                .setName("John")
                .build()

            val person2 = Person.Builder()
                .setIcon(IconCompat.createWithResource(this, R.drawable.person2))
                .setName("Smith")
                .build()

            // 메시지 스타일
            builder
                .setSmallIcon(android.R.drawable.ic_notification_overlay)
                .setContentTitle("받은 편지함 스타일 설정")
                .setStyle(
                    NotificationCompat.MessagingStyle(person1)
                        // 대화내용 설정 (텍스트, 시간, 보낸사람(Person객체))
                        .addMessage("안녕하세요", System.currentTimeMillis(), person1)
                        .addMessage("반갑습니다", System.currentTimeMillis(), person2)
                        .addMessage("안녕히 가세요", System.currentTimeMillis(), person1)
                        .addMessage("좋은 하루 되세요.", System.currentTimeMillis(), person2)
                )

            notificationManager.notify(60, builder.build())
        }
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
            val importance = NotificationManager.IMPORTANCE_LOW // 중요도
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