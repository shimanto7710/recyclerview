package com.example.scratch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.scratch.R
import com.example.scratch.network_shimanto.call.CallInfo
import com.example.scratch.network_shimanto.call.NRCallback
import com.example.scratch.network_shimanto.call.NetworkCallImpl

import com.example.scratch.network_shimanto.response.DummyResponse
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private val networkCall = NetworkCallImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getDummyDataWithCallback()

        lifecycleScope.launch {
            getDummyDataWithSuspend()
            getDummyDataWithSuspendWithoutCallback()
        }


    }

    private fun getDummyDataWithCallback(){
        networkCall.dummyData(object : NRCallback<DummyResponse> {
            override fun onSuccess(data: DummyResponse?, callInfo: CallInfo?) {
                Log.d("onSuccess", "callback   $data")
            }

            override fun onFailure(th: Throwable, callInfo: CallInfo?) {
                Log.d("onFailure", "callback   $th")
            }

        })
    }

    private suspend fun getDummyDataWithSuspend() {
        networkCall.dummyDataWithSuspend(object : NRCallback<DummyResponse> {
            override fun onSuccess(data: DummyResponse?, callInfo: CallInfo?) {
                Log.d("onSuccess", "suspend   $data")
            }

            override fun onFailure(th: Throwable, callInfo: CallInfo?) {
                Log.d("onFailure", "callback   $th")
            }

        })
    }


    private suspend fun getDummyDataWithSuspendWithoutCallback() {
        networkCall.dummyDataWithSuspendWithoutCallback().let {
            if (it.isSuccessful){
                Log.d("onSuccess", "suspend without callback  ${it.body()}")
            }else{
                Log.d("onFailure", "callback   ${it.message()}")
            }
        }
    }
}