package com.example.amadukan

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        val Pname=intent.getStringExtra("name")
        val Pprice=intent.getStringExtra("price")
        val Prating=intent.getStringExtra("rating")
        val Pdesc=intent.getStringExtra("desc")
        val Pimg=intent.getIntExtra("imgid",0)
//         Toast.makeText(this,Pprice+" "+Prating,Toast.LENGTH_SHORT).show()
        findViewById<ImageView>(R.id.Pimg).setImageResource(Pimg)
        findViewById<TextView>(R.id.Pname).text= Pname
        findViewById<TextView>(R.id.Pprice).text=Pprice
        findViewById<TextView>(R.id.Prating).text=Prating
        findViewById<TextView>(R.id.Pdesc).text=Pdesc

    }
}