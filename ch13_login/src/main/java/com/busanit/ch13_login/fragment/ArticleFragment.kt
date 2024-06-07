package com.busanit.ch13_login.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.busanit.ch13_login.RetrofitClient
import com.busanit.ch13_login.adapter.ArticleAdapter
import com.busanit.ch13_login.databinding.FragmentArticleBinding
import com.busanit.ch13_login.model.Article
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "ArticleFragment"
class ArticleFragment : Fragment() {
    lateinit var binding: FragmentArticleBinding
    lateinit var articleAdapter: ArticleAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // requireContext() : 현재 프래그먼트와 관련된 Context 리턴
        articleAdapter = ArticleAdapter(listOf(), ::updateArticle, ::deleteArticle)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = articleAdapter

        getArticles()


    }

    // 게시글 목록 가져오기
    private fun getArticles() {
        val token = getToken()
        // 레트로핏 데이터 가져오기
        RetrofitClient.api.getArticles("Bearer $token")
            .enqueue(object : Callback<List<Article>> {
                override fun onResponse(
                    call: Call<List<Article>>,
                    response: Response<List<Article>>
                ) {
                    if (response.isSuccessful) {
                        val articles = response.body() ?: emptyList()
                        Log.d(TAG, "onResponse: ${response.body()}")
                        articleAdapter.updateArticles(articles)
                    } else {
                        Log.d(TAG, "onResponse: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<List<Article>>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.message}")
                }
            })
    }

    private fun getToken(): String {
        val sharedPreferences = activity?.getSharedPreferences("app_pref", Context.MODE_PRIVATE)
        // 저장된 토큰을 보호된 리소스 요청 시 사용
        val token = sharedPreferences?.getString("token", "") ?: ""
        return token
    }

    // 수정 이벤트 핸들러
    private fun updateArticle(article: Article) {

    }

    // 삭제 이벤트 핸들러
    private fun deleteArticle(article: Long) {

    }
}