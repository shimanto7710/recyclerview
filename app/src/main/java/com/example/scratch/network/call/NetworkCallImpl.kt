package com.example.scratch.network.call

import com.example.scratch.network.ApiResponse
import com.example.scratch.network.api.ApiClient
import com.example.scratch.network.response.DummyResponse

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NetworkCallImpl : NetworkCall {


    companion object {
        private val TAG = NetworkCallImpl.javaClass
    }

    private var apiClient = ApiClient().getApiService()


    // callback
    override fun dummyData(callback: NRCallback<DummyResponse>) {
        val call = apiClient.callBack()
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

    override suspend fun suspendResponseCallback(callback: NRCallback<DummyResponse>) {
        var response = apiClient.suspendResponseCallback()
        if (response.isSuccessful) {
            callback.onSuccess(response.body(), CallInfo(400, ""))
        } else {
            callback.onSuccess(response.body(), CallInfo(400, ""))
        }
    }

    override suspend fun suspendResponse(): Response<DummyResponse> {
        return apiClient.suspendResponse()
    }

    override suspend fun suspendResponseWithErrorFiltering(): ApiResponse<DummyResponse> {
        var response=apiClient.suspendResponse()
         return ApiResponse.create(response)
    }

    override suspend fun perfectWay(): DummyResponse {
        return apiClient.perfectWay()
    }


//    override suspend fun either():Either<String, DummyResponse>{
//        apiClient.getDummyDataWithSuspend().let {
//            if (it.isSuccessful){
//                return Either.Right(it.body()!!)
//            }else{
//                return Either.Left("")
//            }
//        }
//    }


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

