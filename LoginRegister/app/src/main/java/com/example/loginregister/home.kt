package com.example.loginregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        findViewById<TextView>(R.id.username).text=intent.getStringExtra(Login.KEY).toString()
    }
}