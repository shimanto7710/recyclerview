package com.example.recyclerview.ui.multi_type_recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import kotlinx.android.synthetic.main.item_simple_vertical.view.*


class SimpleAdapterMultiview(private val rootList: List<String>, private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }


    private inner class View1ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var message: TextView = itemView.findViewById(R.id.txt)
        fun bind(position: Int) {
            val recyclerViewModel = rootList[position]
            message.text = "dummy data"
        }
    }

    private inner class View2ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var message: TextView = itemView.findViewById(R.id.txt)
        fun bind(position: Int) {
            val recyclerViewModel = rootList[position]
            message.text = "dummy data"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_ONE) {
            return View1ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_1, parent, false)
            )
        }else{
            return View2ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item__2, parent, false)
            )
        }
    }

    override fun getItemCount(): Int {
        return rootList.size
    }


    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) {
            VIEW_TYPE_ONE
        } else {
            VIEW_TYPE_TWO
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position % 2 == 0) {
            (holder as View1ViewHolder).bind(position)
        } else {
            (holder as View2ViewHolder).bind(position)
        }
    }


}