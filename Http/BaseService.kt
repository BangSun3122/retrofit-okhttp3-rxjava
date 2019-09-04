package com.example.myapplication.ror.Http

import com.example.myapplication.ror.bean.AndroidBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface BaseService {

    /**
     * 根据category获取Android、ios等数据
     * category：类型
     * count：分页的一页数据
     * page：第几页
     */
    @GET("search/query/listview/category/{category}/count/{count}/page/{page}")
    fun getCategoryData(@Path("category") category: String,
                        @Path("count") count: Int,
                        @Path("page") page: Int): Observable<AndroidBean>

}