package com.example.recyclerview.pref


interface PrefHelper {

    fun resetAll()


    fun isFirstOpen(): Boolean
    fun setFirstOpenStatus(isFirstOpen: Boolean)

    fun getUserId(): String?
    fun setUserId(id: String)

    fun isLoggedIn(): Boolean
    fun setLoginStatus(isLoggedIn: Boolean)
    fun logout()

    fun isAccessTokenExist(): Boolean
    fun getAccessToken(): String?
    fun setAccessToken(token: String)

    fun getMsisdn(): String?
    fun setMsisdn(msisdn: String)

    fun getDeviceId(): String
    fun setDeviceId(deviceId: String)

    fun getLocale(): String
    fun setLocale(locale: String)

    fun getSelectedTheme(): String
    fun setSelectedTheme(theme: String)





}