package com.example.scratch.pref


class PrefHelperImpl : PrefHelper {


    private var prefUtils: PrefUtils = PrefUtils.getInstance()

    private val userSessionKeys = arrayOf(
            Pk.isLoggedIn,
            Pk.userId,
            Pk.userAccessToken,
            Pk.userMsisdn
    )

    override fun resetAll() {
        prefUtils.clear()
    }



    override fun isFirstOpen(): Boolean {
        return prefUtils.getBoolean(Pk.isFirstOpen.name, true)
    }

    override fun setFirstOpenStatus(isFirstOpen: Boolean) {
        prefUtils.putBoolean(Pk.isFirstOpen.name, isFirstOpen)
    }

    override fun getUserId(): String? {
        return prefUtils.getString(Pk.userId.name, null)
    }

    override fun setUserId(id: String) {
        prefUtils.putString(Pk.userId.name, id)
    }

    override fun isLoggedIn(): Boolean {
        return prefUtils.getBoolean(Pk.isLoggedIn.name, false)
//        return isAccessTokenExist()
    }

    override fun setLoginStatus(isLoggedIn: Boolean) {
        prefUtils.putBoolean(Pk.isLoggedIn.name, isLoggedIn)

    }

    override fun isAccessTokenExist(): Boolean {
        val token = getAccessToken()
        if (token.isNullOrEmpty()) return false

        return true
    }

    override fun getAccessToken(): String? {
        return prefUtils.getString(Pk.userAccessToken.name, null)
    }

    override fun setAccessToken(token: String) {
        prefUtils.putString(Pk.userAccessToken.name, token)
    }

    override fun logout() {
        for (item in userSessionKeys) {
            prefUtils.remove(item.name)
        }
    }

    override fun setMsisdn(msisdn: String) {
        prefUtils.putString(Pk.userMsisdn.name, msisdn)
    }

    override fun getMsisdn(): String? {
        return prefUtils.getString(Pk.userMsisdn.name, null)
    }

    override fun getDeviceId(): String {
        return prefUtils.getString(Pk.deviceId.name, null)
    }

    override fun setDeviceId(deviceId: String) {
        prefUtils.putString(Pk.deviceId.name, deviceId)
    }

    override fun getLocale(): String {
        return prefUtils.getString(Pk.locale.name, "en")
    }

    override fun setLocale(locale: String) {
        prefUtils.putString(Pk.locale.name, locale)
    }

    override fun getSelectedTheme(): String {
        return prefUtils.getString(PrefConstant.THEME, PrefConstant.THEME_LIGHT)
    }

    override fun setSelectedTheme(theme: String) {
        prefUtils.putString(PrefConstant.THEME, theme)
    }


}