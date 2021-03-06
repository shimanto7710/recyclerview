package com.example.recyclerview.ui.multi_type_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.ui.simple_recyclerview.SimpleAdapterHorizontal
import com.example.recyclerview.ui.simple_recyclerview.SimpleAdapterVertical
import com.example.recyclerview.utls.RecyclerviewExtentions.LinearHorizontalItemDecoration
import kotlinx.android.synthetic.main.activity_multiview_recyclerview.*
import kotlinx.android.synthetic.main.activity_simple_recyclerview.*

class MultiviewRecyclerviewActivity : AppCompatActivity() {
    lateinit var multiAdapter: SimpleAdapterMultiview
    lateinit var list: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiview_recyclerview)
        initRecyclerViewHorizontal()
    }

    private fun initRecyclerViewHorizontal() {
        list = ArrayList()
        list.add("adss")
        list.add("adss")
        list.add("adss")
        list.add("adss")
        list.add("adss")
        multiAdapter = SimpleAdapterMultiview(list, this)
        var layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        multiRecyclerview.layoutManager = layoutManager
        multiRecyclerview.addItemDecoration(LinearHorizontalItemDecoration(0))
        multiRecyclerview.adapter = multiAdapter
    }
}