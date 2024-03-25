package com.example.shopnow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var productArrayList:ArrayList<user>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name= arrayOf("Cap","Bag","Head Phone","Shoes", "Watch")
        val price= arrayOf("$5","$8","$10","$7","$6")
        val rate= arrayOf("4.2","3.8","4.5","3.2","2.2")
        val imageId= intArrayOf(R.drawable.cap_pic,R.drawable.bag_pic,
            R.drawable.headphone_pic,R.drawable.shoes_pic,R.drawable.watch_pic)

        productArrayList=ArrayList()

        for (i in name.indices){
            val userData=user(name[i],price[i],rate[i],imageId[i])
            productArrayList.add(userData)
        }

        val listview=findViewById<ListView>(R.id.lv)
        listview.isClickable=true
        listview.adapter= MyAdapter(this, productArrayList)


    }
}