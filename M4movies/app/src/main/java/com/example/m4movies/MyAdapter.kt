package com.example.m4movies

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var movieList: ArrayList<Data>, var context:Activity):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        private lateinit var myListener: onItemClickListener
        interface onItemClickListener{
            fun onItemClick(position: Int)
        }

    fun setItemClickListener(Listener: onItemClickListener){
        myListener=Listener
    }

// it holds the view so views are not created every time.
    class MyViewHolder(var view: View, listener: onItemClickListener):RecyclerView.ViewHolder(view){
        val poster= view.findViewById<ImageView>(R.id.imageView)
        val title= view.findViewById<TextView>(R.id.textView2)
        init {
            view.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
    // to create new view instance, when layout manager fails to find suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itemview,parent, false)
        return MyViewHolder(itemView, myListener )
    }

    //how many list items are present in your array
    override fun getItemCount(): Int {
       return movieList.size
    }

    // populate items with data
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var currentMovies = movieList[position]
        holder.poster.setImageResource(currentMovies.poster)
        holder.title.text= currentMovies.title
    }
}