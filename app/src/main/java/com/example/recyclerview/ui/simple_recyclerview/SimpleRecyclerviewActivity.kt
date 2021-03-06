package com.example.recyclerview.ui.simple_recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.utls.RecyclerviewExtentions.GridItemDecoration
import com.example.recyclerview.utls.RecyclerviewExtentions.LinearHorizontalItemDecoration
import com.example.recyclerview.utls.RecyclerviewExtentions.LinearVerticalItemDecoration
import kotlinx.android.synthetic.main.activity_simple_recyclerview.*

class SimpleRecyclerviewActivity : AppCompatActivity() {
    lateinit var adapterVertical:SimpleAdapterVertical
    lateinit var adapterHorizontal: SimpleAdapterHorizontal
    lateinit var adapterGrid: SimpleAdapterGrid
    lateinit var verticalList:ArrayList<String>
    lateinit var horizontalList:ArrayList<String>
    lateinit var gridList:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_recyclerview)
        initRecyclerViewVertical()
        initRecyclerViewHorizontal()
        initRecyclerViewGrid()
    }

    private fun initRecyclerViewVertical(){
        verticalList= ArrayList()
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        adapterVertical= SimpleAdapterVertical(verticalList)
        var layoutManager=LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        simpleVerticalRecyclerView.layoutManager= layoutManager
        simpleVerticalRecyclerView.addItemDecoration(LinearVerticalItemDecoration(0))
        simpleVerticalRecyclerView.adapter=adapterVertical
    }

    private fun initRecyclerViewHorizontal(){
        horizontalList= ArrayList()
        horizontalList.add("adss")
        horizontalList.add("adss")
        horizontalList.add("adss")
        horizontalList.add("adss")
        horizontalList.add("adss")
        adapterHorizontal= SimpleAdapterHorizontal(horizontalList)
        var layoutManager=LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        simpleHorizontalRecyclerView.layoutManager= layoutManager
        simpleHorizontalRecyclerView.addItemDecoration(LinearHorizontalItemDecoration(0))
        simpleHorizontalRecyclerView.adapter=adapterHorizontal
    }

    private fun initRecyclerViewGrid(){
        gridList= ArrayList()
        gridList.add("adss")
        gridList.add("adss")
        gridList.add("adss")
        gridList.add("adss")
        gridList.add("adss")
        adapterGrid= SimpleAdapterGrid(gridList)
        var layoutManager=GridLayoutManager(this, 3)

        simpleGridRecyclerView.layoutManager= layoutManager
        simpleGridRecyclerView.addItemDecoration(GridItemDecoration(0))
        simpleGridRecyclerView.adapter=adapterGrid
    }
}