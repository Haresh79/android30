package com.example.fullfunctionalapp

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import java.net.URL

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val ctbtn=findViewById<Button>(R.id.ctbtn)
        val androidBtn=findViewById<Button>(R.id.button1)
        val webBtn=findViewById<Button>(R.id.button2)
        val javaBtn=findViewById<Button>(R.id.button3)
        val dsaBtn=findViewById<Button>(R.id.button4)
        androidBtn.setOnClickListener {
            btnNo=0
            intent=Intent(applicationContext, MainActivity3::class.java)
            startActivity(intent)
        }
        webBtn.setOnClickListener {
            btnNo=1
            intent=Intent(applicationContext, MainActivity3::class.java)
            startActivity(intent)
        }
        javaBtn.setOnClickListener {
            btnNo=2
            intent=Intent(applicationContext, MainActivity3::class.java)
            startActivity(intent)
        }
        dsaBtn.setOnClickListener {
            btnNo=3
            intent=Intent(applicationContext, MainActivity3::class.java)
            startActivity(intent)
        }
        ctbtn.setOnClickListener {
               val it = Intent(Intent.ACTION_DIAL)
               it.data = Uri.parse("tel:+917381876799")
               startActivity(it)
        }
    }

}