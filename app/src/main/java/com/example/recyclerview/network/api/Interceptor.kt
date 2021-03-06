package com.example.recyclerview.network.api

import android.net.TrafficStats
import android.util.Log
import com.example.recyclerview.network.NetworkConstant
import com.example.recyclerview.pref.PrefUtils


import okhttp3.Interceptor
import okhttp3.Response

/**
 * Interceptor to add auth token to requests
 */
class Interceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        TrafficStats.setThreadStatsTag(10000)
        val requestBuilder = chain.request().newBuilder()

        val authorization = PrefUtils.getInstance().getString(NetworkConstant.TOKEN, null)

        Log.d("UserAUTH", "" + authorization)
//        requestBuilder.addHeader("x-auth-token", authorization ?: "")
        requestBuilder.addHeader("Authorization", "Bearer $authorization")
        requestBuilder.addHeader("Content-Type", "application/json")


        val response = chain.proceed(requestBuilder.build())

        if (response.code() == 401) {
//            Logout User
        }

        return chain.proceed(requestBuilder.build())
    }
}