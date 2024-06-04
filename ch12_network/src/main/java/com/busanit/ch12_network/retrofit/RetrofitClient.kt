package com.busanit.ch12_network.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// 3. 레트로핏 싱글톤 인스턴스 생성

object RetrofitClient {
    const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    // Retrofit 객체 생성
    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())   // JSON 변환을 위한 컨버터
            .build()

        // API 인터페이스는 레트로핏을 사용하여 구현
        retrofit.create(ApiService::class.java)
    }
}