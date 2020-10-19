package com.cxz.httplib.dao.order

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import com.cxz.common.spread.api
import com.cxz.httplib.base.BaseInfo
import com.cxz.httplib.info.order.OrderInfo
import com.cxz.httplib.maneger.HttpManager
import kotlinx.coroutines.flow.Flow

class OrderDAO {

    val TAG = javaClass.simpleName

    //通过Retrofit获取接口服务对象
    //注意 ******
    //1. retrofit 2.6以后不用await也不用切换线程了，它内部已经处理了
    //2. 在Api中的方法要定义成挂起 suspend
    suspend fun getData(): BaseInfo<OrderInfo> {
        return HttpManager.getHttpService().getBaidu()
    }

    suspend fun getData1(): BaseInfo<OrderInfo> {
        return HttpManager.getHttpService().getBaidu1()

    }


    suspend fun getData2(): BaseInfo<OrderInfo> {

        return HttpManager.getHttpService().getBaidu2()

    }

    suspend fun getDatas(): DataSource.Factory<Int, BaseInfo<OrderInfo>> {

        return HttpManager.getHttpService().getDatas()

    }


    fun getOrderData(): LiveData<BaseInfo<OrderInfo>> {
        return liveData<BaseInfo<OrderInfo>> {
            api { HttpManager.getHttpService().getBaidu() }
        }

    }

}
