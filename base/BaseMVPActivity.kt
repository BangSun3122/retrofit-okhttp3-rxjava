package com.example.myapplication.ror.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.ror.UI.inter.IBaseView

abstract class BaseMVPActivity<V, T : BasePresenter<V>> : AppCompatActivity(), IBaseView {

    private var baseLoadingView: BaseLoadingView? = null
    private var basePresenter: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        basePresenter = getPresenter()
        basePresenter?.attachView(this as V)
        initLoadingView()
        initView()
        initData()
        initEvent()
    }

    abstract fun getLayoutId(): Int

    abstract fun initData()

    abstract fun initView()

    abstract fun initEvent()

    abstract fun getPresenter(): T


    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()

        // 销毁dialog
        if (null != baseLoadingView && baseLoadingView!!.isShowing) {
            baseLoadingView?.dismiss()
        }
        baseLoadingView = null

        // 在activity销毁时，解绑activity和presenter
        if (basePresenter != null) {
            basePresenter?.detachView()
            basePresenter = null
        }
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onPause() {
        super.onPause()
    }

    private fun initLoadingView() {
        baseLoadingView = BaseLoadingView(this, R.style.transparent_dialog)
    }

    private fun showLoadingView() {
        if (null != baseLoadingView) {
            baseLoadingView?.show()
        } else {
            initLoadingView()
            baseLoadingView?.show()
        }
    }

    private fun hideLoadingView() {
        if (null != baseLoadingView && baseLoadingView!!.isShowing) {
            baseLoadingView?.cancel()
        }
    }

    /**
     * 将显示dialog和取消dialog放在了基础类中
     */
    override fun showLoading() {
        showLoadingView()
    }

    override fun hideLoading() {
        hideLoadingView()
    }

}