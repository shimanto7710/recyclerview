package com.example.scratch.network_shimanto.call

data class ApiResponse<out T>(val data: T, val callInfo: CallInfo)
//{
//    fun <T> success(data: T):ApiResponse<T>{
//        return ApiResponse(data,CallInfo(404,"aasd"))
//    }
//}