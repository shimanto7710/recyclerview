package com.example.recyclerview.ui.pagination

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import java.util.*
import kotlin.collections.ArrayList

class PaginationAdapterKotlin(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    private var rootList:ArrayList<PaginationModel> =ArrayList()
    private val LOADING = 0
    private val ITEM = 1
    private var isLoadingAdded = false




    fun setMovieList(orderList: ArrayList<PaginationModel>) {
        rootList = orderList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder: RecyclerView.ViewHolder? = null
        val inflater = LayoutInflater.from(parent.context)
        when (viewType) {
            ITEM -> {
                val viewItem: View =
                    inflater.inflate(R.layout.item_simple_vertical, parent, false)
                viewHolder = OrderListViewHolder(viewItem)
            }
            LOADING -> {
                val viewLoading: View =
                    inflater.inflate(R.layout.item_progress, parent, false)
                viewHolder = LoadingViewHolder(viewLoading)
            }
        }
        return viewHolder!!
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val orderListModel = rootList!![position]
        when (getItemViewType(position)) {
            ITEM -> {
            }
            LOADING -> {
                val loadingViewHolder = holder as LoadingViewHolder
                loadingViewHolder.progressBar.visibility = View.VISIBLE
            }
        }
    }


    override fun getItemCount(): Int {
        return if (rootList == null) 0 else rootList!!.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == rootList!!.size - 1 && isLoadingAdded) LOADING else ITEM
    }

    fun addLoadingFooter() {
        isLoadingAdded = true
        add(PaginationModel())
    }

    fun removeLoadingFooter() {
        isLoadingAdded = false
        val position = rootList!!.size - 1
        val result = getItem(position)
        if (result != null) {
            rootList!!.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun add(orderListModel: PaginationModel) {
        rootList!!.add(orderListModel)
        notifyItemInserted(rootList!!.size - 1)
    }

    fun addAll(moveResults: List<PaginationModel>) {
        for (result in moveResults) {
            add(result)
        }
    }

    fun removeAll() {
        rootList.removeAll(rootList)
        notifyDataSetChanged()
    }

    fun removeItem(orderModel: PaginationModel?) {
        rootList!!.remove(orderModel)
        notifyDataSetChanged()
    }

    fun getItem(position: Int): PaginationModel? {
        return rootList!![position]
    }


    class OrderListViewHolder(itemView: View?) :
        RecyclerView.ViewHolder(itemView!!) {
        private val txtInvoice: TextView? = null
        private val txtInvoiceDate: TextView? = null
        private val txtUserName: TextView? = null
        private val txtUserPhone: TextView? = null
        private val txtShippingFrom: TextView? = null
        private val txtShippingCost: TextView? = null
        private val txtShippingTime: TextView? = null
        private val txtPayment: TextView? = null
        private val txtPrice: TextView? = null
        private val txtStatus: TextView? = null

        //        private Button btnView;
        var spin: Spinner? = null
    }

    class LoadingViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val progressBar: ProgressBar

        init {
            progressBar =
                itemView.findViewById<View>(R.id.loadmore_progress) as ProgressBar
        }
    }


}