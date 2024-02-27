package com.example.fullfunctionalapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi

class MainActivity3 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val webView=findViewById<WebView>(R.id.webView)
        webviewsetup(webView)
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // Check whether the key event is the Back button and if there's history.
        val webView=findViewById<WebView>(R.id.webView)
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        // If it isn't the Back button or there isn't web page history, bubble up to
        // the default system behavior. Probably exit the activity.
        return super.onKeyDown(keyCode, event)
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webviewsetup(webView: WebView){
        val urls= listOf("https://roadmap.sh/android","https://roadmap.sh/full-stack","https://roadmap.sh/java","https://roadmap.sh/datastructures-and-algorithms")
        webView.webViewClient= WebViewClient()
        webView.apply {
            settings.javaScriptEnabled=true
            settings.safeBrowsingEnabled=true
            loadUrl("${urls[btnNo]}")
        }
    }

}