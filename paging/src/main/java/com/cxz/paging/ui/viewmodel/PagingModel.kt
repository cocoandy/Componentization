package com.cxz.paging.ui.viewmodel

import android.graphics.pdf.PdfDocument
import androidx.lifecycle.*
import androidx.paging.Config
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.cxz.common.base.BaseViewModel
import com.cxz.common.spread.e
import com.cxz.dblib.entity.OrderEntity
import com.cxz.dblib.maneger.DBManeger
import com.cxz.httplib.dao.order.OrderDAO
import com.cxz.httplib.info.order.OrderInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf

class PagingModel : BaseViewModel() {
    private val db = DBManeger.db.orderDAO()
    private val mOrderDAO = OrderDAO()
    private val config = Config(pageSize = 15, enablePlaceholders = false, maxSize = 45)
    val mOrderList: LiveData<PagedList<OrderEntity>> = db.getOrders().toLiveData(config)

    fun getData(lifecycle: LifecycleOwner) {
        val mOrderList: LiveData<PagedList<OrderEntity>> = db.getOrders().toLiveData(config)
        mOrderList.observe(lifecycle, Observer {
            "${it.size} -------->>>>>".e("TAG_List")
        })
    }

}