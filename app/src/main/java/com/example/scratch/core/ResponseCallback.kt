package com.example.scratch.core


interface ResponseCallback<T> {

    fun onSuccess(data: T?)

    fun onFailure(th: Throwable)

}