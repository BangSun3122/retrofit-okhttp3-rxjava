package com.example.myapplication.ror.Util

import android.util.Log

object LogUtil {

    fun showLog(tag: String = "taonce", msg: String) {
        Log.d(tag, msg)
    }
}