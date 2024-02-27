package com.example.multiscreenapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.multiscreenapp.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {
    private  lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val customerOrder= intent.getStringExtra(MainActivity.KEY)
        binding.textView2.text=customerOrder.toString()
    }
}