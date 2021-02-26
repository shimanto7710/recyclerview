package com.example.scratch.core

import android.app.Application
import com.example.scratch.core.Contextor

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Contextor.getInstance().init(applicationContext)
//        com.xlib.limeutils.core.Contextor.getInstance().init(applicationContext)

//        Log.d("contextor","asdasdasddddddddddddddd")

        //FirebaseApp.initializeApp(this)

    }


}