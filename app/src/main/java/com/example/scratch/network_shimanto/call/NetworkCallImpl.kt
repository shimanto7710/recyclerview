package com.example.scratch.network_shimanto.call

import android.util.Log
import com.example.scratch.network_shimanto.api.ApiClient
import com.example.scratch.network_shimanto.response.DummyResponse

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NetworkCallImpl : NetworkCall {


    companion object {
        private val TAG = NetworkCallImpl.javaClass
    }

    private var apiClient = ApiClient().getApiService()


    override fun dummyData(callback: NRCallback<DummyResponse>) {
        val call = apiClient.getDummyData()
        call?.enqueue(object : Callback<DummyResponse> {
            override fun onFailure(call: Call<DummyResponse>, t: Throwable) {
                var callInfo = CallInfo(404, "connection failed")
                callback.onFailure(t, callInfo)
            }

            override fun onResponse(call: Call<DummyResponse>, response: Response<DummyResponse>) {
                var callInfo = CallInfo(response.code(), response.message())
                callback.onSuccess(response.body(), callInfo)
            }

        })
    }

    override suspend fun dummyDataWithSuspend(callback: NRCallback<DummyResponse>) {
         apiClient.getDummyDataWithSuspend().let {
             if (it.isSuccessful){
                 callback.onSuccess(data = it.body(),callInfo = CallInfo(it.code(),it.message()))
             }else{
                 callback.onSuccess(data = it.body(),callInfo = CallInfo(it.code(),it.message()))
             }

         }
    }

    override suspend fun dummyDataWithSuspendWithoutCallback(): Response<DummyResponse> {
        return apiClient.getDummyDataWithSuspend()
    }


//    override fun postToServer(post: PostRequestBody, callback: NRCallback<Void>) {
//        val call = apiClient.postToServer(post)
//        call.enqueue(object : Callback<Void> {
//            override fun onFailure(call: Call<Void>, t: Throwable) {
//                var callInfo = CallInfo(404, "connection failed")
//                callback.onFailure(t, callInfo)
//            }
//
//            override fun onResponse(call: Call<Void>, response: Response<Void>) {
//                var callInfo = CallInfo(response.code(), response.message())
//                callback.onSuccess(response.body(), callInfo)
//            }
//        })
//    }


}

