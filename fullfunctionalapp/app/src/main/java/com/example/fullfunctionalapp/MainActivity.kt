package com.example.fullfunctionalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
var btnNo=0
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1=findViewById<Button>(R.id.button)
        btn1.setOnClickListener {
            intent= Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}