package com.example.myapplication.ror.model

import com.example.myapplication.ror.Http.BaseObserver
import com.example.myapplication.ror.Http.RetrofitUtil
import com.example.myapplication.ror.Http.RxSchedulers
import com.example.myapplication.ror.base.contract.IMainModel
import com.example.myapplication.ror.bean.AndroidBean

class MainModel : IMainModel {
    override fun getAndroidData(category: String, page: Int, listener: IMainModel.OnGetAndroidDataListener) {

        RetrofitUtil.mInstance.getService().getCategoryData(category, 10, page)
            .compose(RxSchedulers.observableTransformer())
            .subscribe(object : BaseObserver<AndroidBean> {
                override fun onSuccess(value: AndroidBean) {
                    listener.onGetAndroidDataFinished(bean = value)
                }

                override fun onFailed() {
                    listener.onGetAndroidDataFinished(null)
                }
            })
    }

}
