package com.example.smartygadgets

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val collectionDataSB = StringBuilder()

        val retrofitClient= Retrofit.Builder()
                      .baseUrl("https://dummyjson.com/")
                      .addConverterFactory(GsonConverterFactory.create())
                      .build()
                      .create(ApiService::class.java)

        val retrofitData= retrofitClient.getGadgets()
        retrofitData.enqueue(object : Callback<gadgets> {
            override fun onResponse(call: Call<gadgets>, response: Response<gadgets>) {
                    val post = response.body()
                    // Handle the retrieved post data
                    val productlist = post?.products!!

                    for (e in productlist){
                        collectionDataSB.append(e.title + ", ")
                    }
                    findViewById<TextView>(R.id.textView).text=collectionDataSB
            }

            override fun onFailure(call: Call<gadgets>, t: Throwable) {
                // Handle failure
            }
        })
    }
}