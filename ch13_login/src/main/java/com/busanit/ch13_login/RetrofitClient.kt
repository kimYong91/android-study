package com.busanit.ch13_login

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    // 안드로이드에서 일반 HTTP 프로토콜 요청은 보안상 금지되어 있음.
    // https : http 프로토콜에 보안이 추가된 프로토콜
    // 안드로이드 에뮬레이터에서 localhost는 에뮬레이터 자기자신을 가리킴
    // 개발 서버의 localhost 접속시 10.0.2.2 IP를 사용
    //private val BASE_URL = "http://10.100.203.69:8080"  // 개인 pc의 ip주소 -> 다른 컴퓨터를 사용하면 다름
    private val BASE_URL = "http://10.0.2.2:8080" // 개인 pc의 localhost(127.0.0.1) 루프백(자기 자신) 주소 -> 다른 컴퓨터를 사용해도 같음
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}