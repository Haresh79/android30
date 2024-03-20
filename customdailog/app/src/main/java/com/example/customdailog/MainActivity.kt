package com.example.customdailog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.customdailog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var i=0

        dialog= Dialog(this)
        dialog.setContentView(R.layout.custom_dialog)
        var yes=dialog.findViewById<Button>(R.id.button2)
        var no=dialog.findViewById<Button>(R.id.button)
        no.setOnClickListener {
            dialog.dismiss()
        }
        yes.setOnClickListener {
            // something happened
        }
        binding.btn.setOnClickListener {
            if (i==0) {
                dialog.show()
                i++
            }
            else{
                Toast.makeText(this,"PDF is downloading now",Toast.LENGTH_SHORT).show()
            }

        }
    }
}