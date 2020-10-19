package com.cxz.httplib.api

import androidx.paging.DataSource
import androidx.paging.PagedList
import com.cxz.httplib.base.BaseInfo
import com.cxz.httplib.info.order.OrderInfo
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface HttpApi {
    @GET("donghui_app_test/salesman/orderList?pageSize=20&salesmanId=2791&startNum=1")
    suspend fun getBaidu(): BaseInfo<OrderInfo>

    @GET("donghui_app_test/salesman/orderList?pageSize=20&salesmanId=2791&startNum=1")
    suspend fun getBaidu1(): BaseInfo<OrderInfo>

    @GET("donghui_app_test/salesman/orderList?pageSize=20&salesmanId=2791&startNum=1")
    suspend fun getBaidu2(): BaseInfo<OrderInfo>

    @GET("donghui_app_test/salesman/orderList?pageSize=20&salesmanId=2791&startNum=1")
    suspend fun getDatas(): DataSource.Factory<Int,BaseInfo<OrderInfo>>
}