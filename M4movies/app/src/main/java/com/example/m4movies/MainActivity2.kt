package com.example.m4movies

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        findViewById<ImageView>(R.id.imageView2).setImageResource(intent.getIntExtra("poster", R.drawable.captain_1))
        findViewById<TextView>(R.id.TVtitle).text= intent.getStringExtra("title")
        findViewById<TextView>(R.id.tvYear).text= intent.getStringExtra("year")
        findViewById<TextView>(R.id.tvMore).text= intent.getStringExtra("more")
    }
}