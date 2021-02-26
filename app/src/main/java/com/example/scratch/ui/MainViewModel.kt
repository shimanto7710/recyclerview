package com.example.scratch.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.liveData
import com.example.scratch.network_shimanto.call.ApiResponse
import com.example.scratch.network_shimanto.call.NetworkCallImpl
import com.example.scratch.network_shimanto.response.DummyResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private val networkCall = NetworkCallImpl()


//        >>>>>>>>>>>>>>>>  just a kotlin coroutine IO thread <<<<<<<<<<<<<<<<<<<<
//    suspend fun getDummyData() =
//        // Dispatchers.Main
//        withContext(Dispatchers.IO) {
//
//        }


    // kotlin coroutine without callback and livedata
    fun getDummyData(): LiveData<DummyResponse?> =
        liveData(Dispatchers.IO) {
            val response = networkCall.dummyDataWithSuspendWithoutCallback()

            if (response.isSuccessful) {
                emit(response.body())
            } else {
                emit(null)
            }
        }

}