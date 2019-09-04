package com.example.myapplication.ror.base

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import com.example.myapplication.R
import kotlinx.android.synthetic.main.base_loading_view.*

class BaseLoadingView : AlertDialog {

    constructor(context: Context, themeResId: Int) : super(context, themeResId)

    constructor(context: Context) : super(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_loading_view)
        loadingView.smoothToShow()

        // 点击屏幕，dialog不消失
        setCanceledOnTouchOutside(false)
    }

}