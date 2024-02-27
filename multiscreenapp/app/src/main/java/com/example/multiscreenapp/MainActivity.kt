package com.example.multiscreenapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.multiscreenapp.databinding.ActivityMain2Binding
import com.example.multiscreenapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object{
        const val KEY="com.example.multiscreenapp.MainActivity.KEY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnOrd.setOnClickListener {
            val orderList = "Hello Your orders are "+binding.eT1.text.toString()+", "+binding.eT2.text.toString()+", "+binding.eT3.text.toString()+" and "+binding.eT4.text.toString()+"."

            intent= Intent(this, MainActivity2::class.java)
            intent.putExtra(KEY, orderList)
            startActivity(intent)
        }

    }
}