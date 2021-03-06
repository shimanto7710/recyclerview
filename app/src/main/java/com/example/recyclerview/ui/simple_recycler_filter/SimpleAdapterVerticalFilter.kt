package com.example.recyclerview.ui.simple_recycler_filter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import kotlinx.android.synthetic.main.item_simple_vertical.view.*


class SimpleAdapterVerticalFilter(private val rootList: ArrayList<String>) : RecyclerView.Adapter<SimpleAdapterVerticalFilter.ViewHolder>(), Filterable {


    private var rootFilterList= ArrayList<String>()
    init {
        rootFilterList=rootList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_simple_vertical, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return rootFilterList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.itemView.tvSimpleItem.text=rootFilterList[position]
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//        val txtName = itemView.findViewById(R.id.tvSimpleItem) as TextView
    }

    override fun getFilter(): Filter? {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                    rootFilterList = rootList
                } else {
                    val filteredList: ArrayList<String> = ArrayList()
                    for (row in rootList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.toLowerCase()
//                                .contains(charString.toLowerCase()) || row.getPhone()
                                .contains(charString.toLowerCase())

                        ) {
                            filteredList.add(row)
                        }
                    }
                    rootFilterList = filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = rootFilterList
                return filterResults
            }

            override fun publishResults(
                charSequence: CharSequence,
                filterResults: FilterResults
            ) {
                rootFilterList = filterResults.values as ArrayList<String>
                notifyDataSetChanged()
            }
        }
    }


}