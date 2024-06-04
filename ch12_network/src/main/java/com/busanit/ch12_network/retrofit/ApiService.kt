package com.busanit.ch12_network.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

// 2. Retrofit 인터페이스 정의
interface ApiService {

    // 해당 API로 get요청을 하면 Call 객체로 반환
    @GET("/posts")
    fun getPosts(): Call<List<Post>>

    @GET("/posts/{id}")
    fun getPostById(@Path("id") id: Int): Call<Post>
}