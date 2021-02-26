package com.example.scratch.network_shimanto.call



/**
 * Copyright 2019 (C) xplo
 *
 * Created  : 2019-11-10
 * Updated  :
 * Author   : xplo
 * Desc     :
 * Comment  :
 */
interface NRCallback<T> {

    fun onSuccess(data: T?, callInfo: CallInfo?)

    fun onFailure(th: Throwable, callInfo: CallInfo?)

}