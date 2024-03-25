package com.example.shopnow

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter (val context: Activity, val arrayList: ArrayList<user>):
    ArrayAdapter<user>(context, R.layout.eachview, arrayList){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater= LayoutInflater.from(context)
        val view= inflater.inflate(R.layout.eachview,null)
        val image = view.findViewById<ImageView>(R.id.imageView)
        val name = view.findViewById<TextView>(R.id.textView)
        val price = view.findViewById<TextView>(R.id.textView3)
        val rate = view.findViewById<TextView>(R.id.textView2)

        image.setImageResource(arrayList[position].imageId)
        name.text=arrayList[position].name
        price.text=arrayList[position].price
        rate.text=arrayList[position].rate

        return super.getView(position, convertView, parent)
    }
}
