package com.example.scratch.utls.RecyclerviewExtentions

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class LinearHorizontalItemDecoration(var space : Int) : RecyclerView.ItemDecoration() {


    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.right = space
        outRect.left = space
        // Add top margin only for the first item to avoid double space between items
        if(parent.getChildAdapterPosition(view) == 0) {
            outRect.left = 0;
        }

    }

}