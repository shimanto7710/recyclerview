package com.example.recyclerview.network.api

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.example.recyclerview.network.NetworkConstant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Retrofit instance class
 */
class ApiClient {
    private lateinit var apiService: ApiEndpoint

    fun getApiService(): ApiEndpoint {

        // Initialize ApiService if not initialized yet
        if (!::apiService.isInitialized) {
            val retrofit = Retrofit.Builder()
                .baseUrl(NetworkConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient())
                .build()

            apiService = retrofit.create(ApiEndpoint::class.java)
        }

        return apiService
    }

    @SuppressLint("ServiceCast")
    fun hasNetwork(context: Context): Boolean? {
        var isConnected: Boolean? = false // Initial Value
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }

    /**
     * Initialize OkhttpClient with our interceptor
     */
    private fun okhttpClient(): OkHttpClient {
//        val cacheSize = (10 * 1024 * 1024).toLong()
//        val myCache = Cache(Contextor.sInstance?.context?.cacheDir, cacheSize)
        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(Interceptor())
//            .addNetworkInterceptor(AuthInterceptor())
            .addInterceptor(getLoggingInterceptor())
            .build()
    }

    private fun getLoggingInterceptor(): okhttp3.Interceptor? {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

}