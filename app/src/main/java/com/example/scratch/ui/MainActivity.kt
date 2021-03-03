package com.example.scratch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.example.scratch.R
import com.example.scratch.network.Status
import com.example.scratch.network.call.CallInfo
import com.example.scratch.network.call.NRCallback
import com.example.scratch.network.call.NetworkCallImpl

import com.example.scratch.network.response.DummyResponse
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private val networkCall = NetworkCallImpl()

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        // initialization
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)





        // callback without suspend // tested
        getDummyDataWithCallback()
        getDataFinalWay()

        lifecycleScope.launch {
//            viewModel.suspendResponseCallback()
//            suspendResponseCallback()
        }


    }

    // callback without suspend
    // tested -> working fine
    private fun getDummyDataWithCallback() {
        networkCall.dummyData(object : NRCallback<DummyResponse> {
            override fun onSuccess(data: DummyResponse?, callInfo: CallInfo?) {
                Log.d("response", "callback   $data")
            }

            override fun onFailure(th: Throwable, callInfo: CallInfo?) {
                Log.d("response", "callback   $th")
            }

        })
    }

    // callback with suspend
    // should be used try catch and yet to implemented
    // tested -> crashed if there is no internet so use try catch to handle errors
    // have to call in kotlin corutine scope
    private suspend fun suspendResponseCallback() {
        networkCall.suspendResponseCallback(object : NRCallback<DummyResponse> {
            override fun onSuccess(data: DummyResponse?, callInfo: CallInfo?) {
                Log.d("response", "suspendResponseCallback   $data")
            }

            override fun onFailure(th: Throwable, callInfo: CallInfo?) {
                Log.d("response", "suspendResponseCallback   $th")
            }

        })
    }


    // perfect way
    // by suspend //tested
    // all error handle by try catch and resource class
    // viewmodel is ussed
    private fun getDataFinalWay() {
        viewModel.perfectWay().observe(this, Observer {
//            it?.let { resource ->
//                when (resource.status) {
//                    Status.SUCCESS -> {
//                        Log.d("response", "returnEmpty   ${resource.data}")
//                    }
//                    Status.ERROR -> {
//                        Log.d("response", "returnEmpty   ${it.message}")
//                    }
//                    Status.LOADING -> {
//                        Log.d("response", "returnEmpty   loading")
//                    }
//                }
//            }

            when (it.status) {
                Status.SUCCESS -> {
                    Log.d("response", "returnEmpty   ${it.data}")
                }
                Status.ERROR -> {
                    Log.d("response", "returnEmpty   ${it.message}")
                }
                Status.LOADING -> {
                    Log.d("response", "returnEmpty   loading")
                }
            }
        })
    }


}