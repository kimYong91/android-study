package com.busanit.ch12_network.retrofit

import com.busanit.ch12_network.retrofit.model.Comment
import com.busanit.ch12_network.retrofit.model.NewPost
import com.busanit.ch12_network.retrofit.model.Post
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

// 2. Retrofit 인터페이스 정의
interface ApiService {

    // 해당 API로 get요청을 하면 Call 객체로 반환
    @GET("/posts")
    fun getPosts(): Call<List<Post>>

    // 경로 변수(Path)를 통해서 해당 id의 게시물을 가져옴
    @GET("/posts/{id}")
    fun getPostById(@Path("id") id: Int): Call<Post>

    // 쿼리 파라미터를 통해서 동적으로 특정 게시물의 댓글을 가져옴
    @GET("/comments") // 정보를 가져오는 GET규약에 맞췃서 설정
    fun getCommentsByPostId(@Query("postId") postId: Int): Call<List<Comment>>

    // POST 요청, 요청 본문으로 데이터 객체를 받아, 요청하고 Post 객체를 반환
    @POST("/posts")
    fun createPost(@Body newPost: NewPost): Call<Post>
}