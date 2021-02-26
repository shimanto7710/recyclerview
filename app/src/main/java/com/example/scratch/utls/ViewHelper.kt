package com.example.scratch.utls

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.os.Handler
import android.view.View
import android.view.WindowManager


object ViewHelper {


    //Notice bar white color
     fun setLightStatusBar(view: View, activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            var flags = view.systemUiVisibility
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            view.systemUiVisibility = flags
            activity.window.statusBarColor = Color.WHITE
        }
    }

    fun White_transparentStatusBar(view: View, activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val w = activity.window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
            val flags = view.systemUiVisibility
            //flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.systemUiVisibility = flags
        }
    }

    fun transparentStatusBar(view: View, activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val w = activity.window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
            var flags = view.systemUiVisibility
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            view.systemUiVisibility = flags
        }
    }


    fun blinkItem(itemView: View) {
        itemView.visibility = View.INVISIBLE
        val handler = Handler()
        handler.postDelayed({ itemView.visibility = View.VISIBLE }, 100)

    }

}

