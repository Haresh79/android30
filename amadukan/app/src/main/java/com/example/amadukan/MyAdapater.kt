package com.example.amadukan

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.security.AccessControlContext

class MyAdapater(val context: Activity, val arrayList: ArrayList<user>):
    ArrayAdapter<user>(context, R.layout.eachview, arrayList){
     override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

         val inflater= LayoutInflater.from(context)
         val view= inflater.inflate(R.layout.eachview, null)

         view.findViewById<TextView>(R.id.Name).text=arrayList[position].name
         view.findViewById<TextView>(R.id.rating).text=arrayList[position].rating
         view.findViewById<TextView>(R.id.price).text=arrayList[position].price
         view.findViewById<ImageView>(R.id.image).setImageResource(arrayList[position].imagId)

         return view

         }
    }
