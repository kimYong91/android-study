package com.busanit.ch14_etc.webview

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ch14_etc.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 웹뷰 인터넷 사용하려면 Manifest 파일에 인터넷 권한 설정
        binding.run {
            // WebView 설정 (웹뷰를 통해 링크를 열도록 클라이언트 설정)
            webView.webViewClient = WebViewClient()
            webView.loadUrl("https://www.naver.com")

            // 웹 뷰 웹 설정
            webView.settings.javaScriptEnabled = true
            // 캐시 모드 설정
            webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
            webView.clearCache(true)

            // 줌 컨트롤 사용
            webView.settings.setSupportZoom(true)
        }

    }
}