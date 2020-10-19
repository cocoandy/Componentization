package com.cxz.order.ui.viewmodel

import androidx.lifecycle.*
import com.cxz.common.base.BaseViewModel
import com.cxz.httplib.base.BaseInfo
import com.cxz.httplib.info.order.OrderInfo
import com.cxz.httplib.dao.order.OrderDAO
import com.cxz.common.spread.api
import kotlinx.coroutines.*

class OrderViewModel : BaseViewModel() {
    private val mOrderDAO = OrderDAO()
    val asyncOrder = MutableLiveData<MutableList<BaseInfo<OrderInfo>>>()
    val modelOrder = MutableLiveData<BaseInfo<OrderInfo>>()
    val modelOrders = MutableLiveData<OrderInfo>()
    val liveOrder = MutableLiveData<BaseInfo<OrderInfo>>()

    fun modelOrder() {
        viewModelScope.launch() {
            api(modelOrder) { mOrderDAO.getData() }
        }
    }


    //返回的Livedata的数据用map去把值传给另一个MutableLiveData
    fun liveOrder() {
    }

    /**
     * async{}  进行并发操作
     */
    fun asyncOrder() {

        viewModelScope.launch {

            val data = async { api { mOrderDAO.getData() } }
            val data1 = async { api { mOrderDAO.getData1() } }
            val data2 = async { api { mOrderDAO.getData2() } }
            val orderList = mutableListOf<BaseInfo<OrderInfo>>()
            orderList.add(data.await())
            orderList.add(data1.await())
            orderList.add(data2.await())
            asyncOrder.value = orderList

        }
    }


}