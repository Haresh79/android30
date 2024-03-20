package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val taskList= arrayListOf<String>()

        val listView=findViewById<ListView>(R.id.lv)


        findViewById<ImageButton>(R.id.addbtn).setOnClickListener {
            val task=findViewById<EditText>(R.id.editTextText).text.toString()
            taskList.add(task)
            findViewById<EditText>(R.id.editTextText).text.clear()

            val myAdaptor=ArrayAdapter(this,android.R.layout.simple_list_item_1, taskList)
            listView?.adapter=myAdaptor

            listView.setOnItemClickListener { parent, view, position, id ->
                Toast.makeText(this, "hii", Toast.LENGTH_SHORT).show()
                taskList.removeAt(position)
                val myAdaptor=ArrayAdapter(this,android.R.layout.simple_list_item_1, taskList)
                listView?.adapter=myAdaptor
            }
        }


    }

}