package com.example.recyclerview.network.call

interface NRCallback<T> {

    fun onSuccess(data: T?, callInfo: CallInfo?)

    fun onFailure(th: Throwable, callInfo: CallInfo?)

}