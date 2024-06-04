package com.busanit.ch12_network.retrofit

// 1. 데이터 클래스 정의
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
