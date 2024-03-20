package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var out=0


        val add=findViewById<Button>(R.id.btnadd)
        val sub=findViewById<Button>(R.id.btnsub)
        val mul=findViewById<Button>(R.id.btnmul)
        val div=findViewById<Button>(R.id.btndiv)

        val res=findViewById<TextView>(R.id.result)

        fun operation( o:String){
            var x=findViewById<EditText>(R.id.editTextNumberDecimal).text.toString().toInt()
            var y=findViewById<EditText>(R.id.editTextNumberDecimal2).text.toString().toInt()
            out= when(o){
                "+"->x+y
                "-"->x-y
                "*"->x*y
                "/"->x/y
                else ->0
            }
        }

        add.setOnClickListener {
            operation("+")
            res.text=out.toString()
        }
        sub.setOnClickListener {
            operation("-")
            res.text=out.toString()
        }
        mul.setOnClickListener {
            operation("*")
            res.text=out.toString()
        }
        div.setOnClickListener {
            operation("/")
            res.text=out.toString()
        }

    }
}