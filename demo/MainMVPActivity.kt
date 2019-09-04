package com.example.myapplication.ror.UI.demo

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.ror.Util.LogUtil
import com.example.myapplication.ror.base.BaseMVPActivity
import com.example.myapplication.ror.base.contract.IMainView
import com.example.myapplication.ror.bean.AndroidBean
import com.example.myapplication.ror.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_show.*


class MainMVPActivity : BaseMVPActivity<IMainView, MainPresenter>(), IMainView {

    private val mainPresenter by lazy {
        getPresenter()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        mainPresenter.getAndroidData("android", 1)
    }

    override fun initView() {
    }

    override fun initEvent() {
    }

    override fun getPresenter(): MainPresenter = MainPresenter(this)

    override fun showAndroidData(bean: AndroidBean) {
        LogUtil.showLog(msg = "$bean")
        rl_android.layoutManager = LinearLayoutManager(this@MainMVPActivity)
        val adapter = MainAdapter(this, R.layout.item_android, bean.results)
        rl_android.adapter = adapter
        adapter.setOnItemClickListener {
            LogUtil.showLog(msg = "Click position is $it")
        }
        adapter.setOnItemLongClickListener {
            LogUtil.showLog(msg = "Long Click position is $it")
            return@setOnItemLongClickListener true
        }
    }

    override fun showErrorMsg(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


}