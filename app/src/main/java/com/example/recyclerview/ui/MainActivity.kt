package com.example.recyclerview.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.recyclerview.R
import com.example.recyclerview.network.Status
import com.example.recyclerview.network.call.NetworkCallImpl
import com.example.recyclerview.ui.multi_type_recyclerview.MultiviewRecyclerviewActivity
import com.example.recyclerview.ui.pagination.SimplePaginationActivity
import com.example.recyclerview.ui.simple_recycler_filter.SimpleRecyclerWithFilterActivity
import com.example.recyclerview.ui.simple_recyclerview.SimpleRecyclerviewActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val networkCall = NetworkCallImpl()

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // initialization
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)



        btnSimpleRecyclerView.setOnClickListener(this)
        btnSimpleRecyclerViewFilter.setOnClickListener(this)
        btnMultiRecyclerview.setOnClickListener(this)
        btnPagination.setOnClickListener(this)


    }


    // perfect way
    // by suspend //tested
    // all error handle by try catch and resource class
    // viewmodel is ussed
    private fun getDataFinalWay() {
        viewModel.perfectWay().observe(this, Observer {
//            it?.let { resource ->
//                when (resource.status) {
//                    Status.SUCCESS -> {
//                        Log.d("response", "returnEmpty   ${resource.data}")
//                    }
//                    Status.ERROR -> {
//                        Log.d("response", "returnEmpty   ${it.message}")
//                    }
//                    Status.LOADING -> {
//                        Log.d("response", "returnEmpty   loading")
//                    }
//                }
//            }

            when (it.status) {
                Status.SUCCESS -> {
                    Log.d("response", "returnEmpty   ${it.data}")
                }
                Status.ERROR -> {
                    Log.d("response", "returnEmpty   ${it.message}")
                }
                Status.LOADING -> {
                    Log.d("response", "returnEmpty   loading")
                }
            }
        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSimpleRecyclerView -> {
                startActivity(Intent(this, SimpleRecyclerviewActivity::class.java))
            }
            R.id.btnSimpleRecyclerViewFilter -> {
                startActivity(Intent(this, SimpleRecyclerWithFilterActivity::class.java))
            }
            R.id.btnMultiRecyclerview -> {
                startActivity(Intent(this, MultiviewRecyclerviewActivity::class.java))
            }
            R.id.btnPagination -> {
                startActivity(Intent(this, SimplePaginationActivity::class.java))
            }

        }
    }


}