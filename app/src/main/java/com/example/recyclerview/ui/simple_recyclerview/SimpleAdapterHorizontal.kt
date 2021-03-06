package com.example.recyclerview.ui.simple_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import kotlinx.android.synthetic.main.item_simple_horizontal.view.*


class SimpleAdapterHorizontal(private val rootList: List<String>) : RecyclerView.Adapter<SimpleAdapterHorizontal.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_simple_horizontal, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return rootList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.itemView.tvSimpleItem.text="Dummy Data"
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//        val txtName = itemView.findViewById(R.id.tvSimpleItem) as TextView
    }



}