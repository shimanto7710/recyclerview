package com.example.recyclerview.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.recyclerview.network.Resource
import com.example.recyclerview.network.call.CallInfo
import com.example.recyclerview.network.call.NRCallback
import com.example.recyclerview.network.call.NetworkCallImpl
import com.example.recyclerview.network.response.DummyResponse
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {

    private val networkCall = NetworkCallImpl()




    // by suspend and callback
    // tested -> crash if there is no internet so use try catch to handle errors
    suspend fun suspendResponseCallback() {
        networkCall.suspendResponseCallback(object : NRCallback<DummyResponse> {
            override fun onSuccess(data: DummyResponse?, callInfo: CallInfo?) {
                Log.d("response", "suspendResponseCallback $data")
            }

            override fun onFailure(th: Throwable, callInfo: CallInfo?) {
                Log.d("response", "suspendResponseCallback failed")
            }

        })
    }

    // suspend by variable livedata
    // tested -> crash if there is no internet so use try catch to handle errors
    val suspendResponse = liveData(Dispatchers.IO) {
        val retrivedTodo = networkCall.suspendResponse()

        emit(retrivedTodo)
    }

    // suspend by function livedata
    // tested -> crash if there is no internet so use try catch to handle errors
    fun suspendResponseFun() :LiveData<DummyResponse> =liveData(Dispatchers.IO) {
        val response = networkCall.suspendResponse()
        if (response.isSuccessful){
            emit(response.body()!!)
        }

//        if (response.isSuccessful) {
//            emit(response.body())
//        } else {
//            emit(null)
//        }
    }

    fun perfectWay() = liveData(Dispatchers.IO){

        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = networkCall.perfectWay()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }


    }


//        >>>>>>>>>>>>>>>>  just a kotlin coroutine IO thread <<<<<<<<<<<<<<<<<<<<
//    suspend fun getDummyData() =
//        // Dispatchers.Main
//        withContext(Dispatchers.IO) {
//
//        }


    // kotlin coroutine without callback and livedata
//    fun getDummyData(): LiveData<DummyResponse?> =
//        liveData(Dispatchers.IO) {
//            val response = networkCall.dummyDataWithSuspendWithoutCallback()
//
//            if (response.isSuccessful) {
//                emit(response.body())
//            } else {
//                emit(null)
//            }
//        }

    // kotlin coroutine without callback and livedata
//    fun getEither(): LiveData<Either<String, DummyResponse>> =
//        liveData(Dispatchers.IO) {
//            val response = networkCall.either()
//
//            val result: Either<String, DummyResponse> =  response
//
//            when (this) {
//                is Either.Right<*> ->  Log.d("eitherData", "right $result")
//                is Either.Left<*> ->  Log.d("eitherData", response.isRight.toString())
//            }
//
//            Log.d("eitherData", response.isRight.toString())
//            emit(response)
//        }


}