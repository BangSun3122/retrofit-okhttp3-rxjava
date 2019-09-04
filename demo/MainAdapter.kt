package com.example.myapplication.ror.UI.demo

import android.content.Context
import android.graphics.Color
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.ror.base.recycler.BaseAdapter
import com.example.myapplication.ror.base.recycler.BaseHolder
import com.example.myapplication.ror.bean.AndroidBean

class MainAdapter(ctx: Context, layoutRes: Int, mData: MutableList<AndroidBean.Results>)
    : BaseAdapter<AndroidBean.Results>(ctx, layoutRes, mData) {
    override fun convert(holder: BaseHolder, position: Int) {
        val title = holder.getView<TextView>(R.id.item_android_title)
        title.apply {
            text = mData[position].desc
            setTextColor(Color.RED)
        }
        holder.getView<TextView>(R.id.item_android_author).apply {
            text = mData[position].who
            setTextColor(Color.BLACK)
        }
        holder.getView<TextView>(R.id.item_android_time).apply {
            text = mData[position].publishedAt
        }
    }
}