package com.busanit.ch12_network.retrofit.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.busanit.ch12_network.databinding.ActivityRetroBinding
import com.busanit.ch12_network.retrofit.RetrofitClient
import com.busanit.ch12_network.retrofit.adapter.PostAdapter
import com.busanit.ch12_network.retrofit.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetroActivity : AppCompatActivity() {
    lateinit var binding: ActivityRetroBinding
    lateinit var adapter: PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val api = RetrofitClient.instance
        api.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    // 네트워크에 성공할 경우 데이터를 가져옴 (엘비스 연산자로 null처리)
                    val posts = response.body() ?: emptyList()
                    // 리사이클러뷰 어댑터 매개변수를 통해 데이터 전달 + 어뎁터 연결
                    adapter = PostAdapter(posts)
                    binding.recyclerView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                // 실패 처리
            }
        })

        // Result API
        val activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            adapter.notifyDataSetChanged()  // 리사이클러뷰 데이터셋 갱신
            binding.recyclerView.scrollToPosition(0)    // 최상단으로 스크롤
        }

        // 버튼을 클릭하면 클 작성 액티비티로 넘어감
        binding.buttonCreate.setOnClickListener {
            val intent = Intent(this, NewPostActivity::class.java)
            // startActivity(intent)   // 결과 반환하지 않을 시
            activityResultLauncher.launch(intent)   // 액티비티 결과 반환
        }
    }
}