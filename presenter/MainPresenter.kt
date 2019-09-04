package com.example.myapplication.ror.presenter

import com.example.myapplication.ror.base.BasePresenter
import com.example.myapplication.ror.base.contract.IMainModel
import com.example.myapplication.ror.base.contract.IMainView
import com.example.myapplication.ror.bean.AndroidBean
import com.example.myapplication.ror.model.MainModel

class MainPresenter(private var mView: IMainView) : BasePresenter<IMainView>(), IMainModel.OnGetAndroidDataListener {

    private var mModel: IMainModel? = null

    init {
        mModel = MainModel()
    }

    fun getAndroidData(category: String, page: Int) {
        this.mView.showLoading()
        this.mModel?.getAndroidData(category, page, this)
    }

    override fun onGetAndroidDataFinished(bean: AndroidBean?) {
        mView.hideLoading()

        bean?.let {
            mView.showAndroidData(it)
        }
    }

}