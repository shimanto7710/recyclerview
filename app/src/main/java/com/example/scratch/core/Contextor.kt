package com.example.scratch.core

import android.annotation.SuppressLint
import android.content.Context

class Contextor {

    lateinit var context: Context

    fun init(context: Context) {
        this.context = context
    }

    companion object {

        @SuppressLint("StaticFieldLeak")
        var sInstance: Contextor? = null

        @JvmStatic
        fun getInstance(): Contextor {
            if (sInstance == null) {
                sInstance = Contextor()
            }
            return sInstance as Contextor
        }

    }
}