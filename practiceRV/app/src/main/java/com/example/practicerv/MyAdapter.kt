package com.example.practicerv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var numbers:Array<String>):RecyclerView.Adapter<MyAdapter.viewHolder>(){

    lateinit var myListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClicking(position: Int)
    }

    fun setItemClickListener(listener: onItemClickListener){
        myListener=listener
    }

    class viewHolder(var view:View, listener: onItemClickListener):RecyclerView.ViewHolder(view){
        init {
            listener.onItemClicking(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return  viewHolder(view, myListener)
    }

    override fun getItemCount(): Int {
       return numbers.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.textView).text=numbers[position]
    }
}
