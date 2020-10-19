package com.cxz.order.ui.viewmodel

import androidx.lifecycle.*
import androidx.paging.Config
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.cxz.common.base.BaseViewModel
import com.cxz.common.spread.e
import com.cxz.dblib.entity.OrderEntity
import com.cxz.dblib.maneger.DBManeger

class PagingModel : BaseViewModel() {
    val db = DBManeger.db.orderDAO()
    val config = Config(pageSize = 15 ,enablePlaceholders = false, maxSize = 45)
    val mOrderList: LiveData<PagedList<OrderEntity>> = db.getOrders().toLiveData(config)




    fun getData(lifecycle: LifecycleOwner) {
        val mOrderList: LiveData<PagedList<OrderEntity>> = db.getOrders().toLiveData(config)
        mOrderList.observe(lifecycle, Observer {
            "${it.size} -------->>>>>".e("TAG_List")
        })
    }


}