package com.example.scratch.network.call

interface NRCallback<T> {

    fun onSuccess(data: T?, callInfo: CallInfo?)

    fun onFailure(th: Throwable, callInfo: CallInfo?)

}