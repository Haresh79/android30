package com.example.practicerv

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val numbers = arrayOf("6185329042", "7429105631", "8956042173", "2018436795", "5362718049", "9801354267", "4710692385", "1234567890", "3579012684", "0000000001","8274916501", "4650281379", "7193258064", "2305149687", "5468032195", "1892375046", "9037164285", "3512807694", "6784021539", "0125463872")

        val myRecyclerView=findViewById<RecyclerView>(R.id.RV)

        myRecyclerView.layoutManager= LinearLayoutManager(this)

        val adapter=MyAdapter(numbers)
        myRecyclerView.adapter=adapter
        adapter.setItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClicking(position: Int) {
                Toast.makeText(this@MainActivity, "Calling", Toast.LENGTH_SHORT).show()
            }
        })


    }
}