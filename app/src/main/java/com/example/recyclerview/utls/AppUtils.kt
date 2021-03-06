package com.example.recyclerview.utls

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.provider.Settings
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.*


object AppUtils {

    lateinit var progressDialog: ProgressDialog

    fun showKeyboard(activity: Activity, editText: EditText) {
        try {
            editText.requestFocus()
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInput(
                InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY
            )
        } catch (e: Exception) {

        }
    }

    fun hideKeyboard(activity: Activity) {
        val view = activity.findViewById<View>(android.R.id.content)
        try {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        } catch (e: Exception) {

        }
    }


    fun getDeviceID(context: Context): String? {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID)
    }


    fun getDaysDifference(fromDate: Date?, toDate: Date?): Long {
        return if (fromDate == null || toDate == null) 0 else ((toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24))
    }


    fun showLoading(activity: Activity, message: String = "Loading..") {
        progressDialog = ProgressDialog(activity)
        progressDialog.setMessage(message)
        progressDialog.setCancelable(false)
        progressDialog.show()
    }

    fun hideLoading() {
        if (progressDialog != null && progressDialog?.isShowing) {
            progressDialog?.dismiss()
        }
    }

    fun getDateFormat(date: String): String {
        var date =
            SimpleDateFormat("yyyy-MM-dd").parse(date)
        var a = SimpleDateFormat("yyyy-MM-dd").format(date)
        return a
    }


    fun isValidPhoneNumber(number: String?): Boolean {
        return if (number != null && number != "" && number.length < 11 && number.length > 9 && TextUtils.isDigitsOnly(
                "0123456789"
            )) {
            true
        } else false
    }

    fun isValidOTP(number: String?): Boolean {
        return if (number != null && number != "" && number.length < 5 && number.length > 3 && TextUtils.isDigitsOnly(
                "0123456789"
            )) {
            true
        } else false
    }

    fun isValidPassword(number: String?): Boolean {
        return if (number != null && number != "" && number.length < 15 && number.length > 1) {
            true
        } else false
    }


    fun getSubstring(st: String): String {
        if (st.length > 25)
            return st.substring(0, 22).toString() + " . . ."
        else
            return st
    }

    fun getBracketText(value : String) : String{
        return "("+value+")"
    }

    fun Bullet(){
//        val tv = findViewById(R.id.textView1) as TextView
//        val circle = "\u25CF"
//        val sentence = "$circle  Hello its me\n"
//        tv.text = sentence
    }

}