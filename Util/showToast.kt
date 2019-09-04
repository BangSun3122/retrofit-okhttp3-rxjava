package com.example.myapplication.ror.Util

import android.widget.Toast
import com.example.myapplication.ror.App

fun showToast(msg: String) {
    Toast.makeText(
        App.app.applicationContext,
        msg, Toast.LENGTH_SHORT).show()
}