package com.cxz.paging.ui.activity

import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.cxz.common.base.BaseActivity
import com.cxz.common.spread.e
import com.cxz.common.spread.init
import com.cxz.common.spread.showToast
import com.cxz.common.spread.toGsonString
import com.cxz.dblib.entity.OrderEntity
import com.cxz.dblib.maneger.DBManeger
import com.cxz.paging.R
import com.cxz.paging.ui.adapter.PagingAdapter
import com.cxz.paging.ui.viewmodel.PagingModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.base_toolbar.*
import kotlinx.android.synthetic.main.paging_local_activity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PagingLocalActivity : BaseActivity() {
    override fun initLayout(): Int = R.layout.paging_local_activity

    val handler = Handler(Looper.getMainLooper())
    val adapter by lazy { PagingAdapter() }
    val viewModel by viewModels<PagingModel>()
    override fun initView() {
        mOrderRecycle.adapter = adapter
        mToolBar.init(activity = this) {
            setTitle("Local Paging")
        }
        mSwipeRefreshLayout.setOnRefreshListener {
            handler.postDelayed(Runnable {
                mSwipeRefreshLayout.isRefreshing = false
            }, 3000)
        }
    }

    override fun initData() {
        viewModel.getData(this)
        viewModel.mOrderList.observe(this, Observer(adapter::submitList))

        lifecycleScope.launch {
            viewModel.cheekAll().collect {
                showMsg(it.toGsonString())
//                adapter.submitList(it)
            }
        }

    }

    override fun initViewEvent() {
        tvInser.setOnClickListener {
            "inserData".e("--->>>")
            inserData()
        }
        tvFind.setOnClickListener {
            "getOrderList".e("--->>>")
            "itemCount: ${adapter.itemCount} -------->>>>>".e("TAG_List")
        }
    }


    fun inserData() {
        lifecycleScope.launch() {
            withContext(Dispatchers.IO) {
                try {
                    DBManeger.db.orderDAO().insertOrderEntitys(initOrders())
                    showMsg("添加数据成功")
                } catch (e: Exception) {
                    showMsg("添加数据失败${Gson().toJson(e)}")
                }

            }
        }
    }


    fun initOrders(): MutableList<OrderEntity> =
        mutableListOf<OrderEntity>(
            OrderEntity("ww", 1231),
            OrderEntity("ee", 1231),
            OrderEntity("rr", 1231),
            OrderEntity("rr", 1231),
            OrderEntity("tt", 1231),
            OrderEntity("yy", 1231),
            OrderEntity("yy", 1231),
            OrderEntity("yy", 1231)
        )


    suspend fun showMsg(msg: String) {
        msg.e("--->>>")
        withContext(Dispatchers.Main) {
            msg.showToast()
        }
    }
}