package com.example.scratch.utls.RecyclerviewExtentions

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridItemDecoration(var space : Int) : RecyclerView.ItemDecoration() {


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.right = space
        outRect.left = space
        outRect.top = space+5
        outRect.bottom = space+5

//        // Add top margin only for the first item to avoid double space between items
//        if(parent.getChildAdapterPosition(view) == 0) {
//            outRect.top = space;
//        }

    }

}