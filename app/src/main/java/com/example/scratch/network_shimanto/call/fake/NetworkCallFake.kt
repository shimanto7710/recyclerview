package com.example.scratch.network_shimanto.call.fake

import com.example.scratch.network_shimanto.call.CallInfo
import com.example.scratch.network_shimanto.call.NRCallback
import com.example.scratch.network_shimanto.call.NetworkCall
import com.example.scratch.network_shimanto.response.DummyResponse
import retrofit2.Response


class NetworkCallFake : NetworkCall {

    var callInfo = CallInfo(200, "ok")
    override fun dummyData(callback: NRCallback<DummyResponse>) {
        TODO("Not yet implemented")
    }

    override suspend fun dummyDataWithSuspend(callback: NRCallback<DummyResponse>) {
        TODO("Not yet implemented")
    }

    override suspend fun dummyDataWithSuspendWithoutCallback(): Response<DummyResponse> {
        TODO("Not yet implemented")
    }


//    override fun getPostById(postId: Long, callback: NRCallback<Post>) {
//        var arrayList=ArrayList<Post>()
////        arrayList=Fake.getPostData()
//        for (post in arrayList){
//            if (post.id==postId){
//                callback.onSuccess(post,callInfo)
//                 break
//            }
//        }
//
//    }


}