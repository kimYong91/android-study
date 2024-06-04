package com.busanit.ch12_network.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.busanit.ch12_network.databinding.ActivityNewsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val api = NewsRetrofitClient.instance

        // API 호출
        api.getTopHeadlines("ba2dfb06a2964a34a688b0b6c8eee5c7", "kr")
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        val articles = response.body()?.articles ?: emptyList()
                        binding.recyclerView.adapter = ArticleAdapter(articles)
                    } else {
                        // 응답(성공 외) 처리
                    }
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    // 요청 실패 처리
                }

            })

    }
}