package com.cxz.order.ui.activity

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.cxz.common.base.BaseActivity
import com.cxz.common.spread.setBiningContentView
import com.cxz.common.spread.e
import com.cxz.common.spread.init
import com.cxz.common.spread.showToast
import com.cxz.dblib.entity.OrderDetailsEntity
import com.cxz.dblib.entity.OrderEntity
import com.cxz.dblib.maneger.DBManeger
import com.cxz.order.R

import com.cxz.order.ui.viewmodel.PagingModel
import com.cxz.order.ui.adapter.PagingAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.base_toolbar.*
import kotlinx.android.synthetic.main.order_paging_activity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class OrderPagingActivity : BaseActivity() {
    override fun initLayout(): Int = R.layout.order_paging_activity
    override fun initContentView() {
        setBiningContentView()
        mToolBar.init(activity = this, icon = R.mipmap.ic_back) {
            setTitle("Extend")
        }
    }

    val adapter = PagingAdapter()
    val orders: MutableList<OrderEntity> = mutableListOf()
    val viewModel by viewModels<PagingModel>()

    override fun initView() {
        mOrderRecycle.adapter = adapter
    }

    override fun initData() {
        getOrderList()
        viewModel.getData(this)
        viewModel.mOrderList.observe(this, Observer(adapter::submitList))

    }

    override fun initViewEvent() {
        tvInser.setOnClickListener {
            "inserData".e("--->>>")
            inserData()
        }
        tvFind.setOnClickListener {
            "getOrderList".e("--->>>")
            "itemCount: ${adapter.itemCount} -------->>>>>".e("TAG_List")
            getOrderList()
        }
    }


    fun getOrderList() {
        adapter.itemCount
        lifecycleScope.launch() {
            var text = ""
            withContext(Dispatchers.IO) {
                val sb = StringBuffer()
                orders.clear()
                orders.addAll(DBManeger.db.orderDAO().getOrderList())

                val gson = Gson()
                for (item in orders) {
                    sb.append(gson.toJson(item))
                    sb.append("\n")
                }
                text = sb.toString()
            }
            tvContent.text = text
        }

    }


    fun inserData() {
        lifecycleScope.launch() {
            withContext(Dispatchers.IO) {
                try {
                    DBManeger.db.orderDAO().insertOrderEntitys(initOrders())
                    showMsg("添加数据成功")
                } catch (e: Exception) {
                    showMsg("添加数据失败")
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

    fun initOrderDetailsEntitys(): MutableList<OrderDetailsEntity> =
        mutableListOf<OrderDetailsEntity>(
            OrderDetailsEntity(1, "qq123", 1231),
            OrderDetailsEntity(2, "ww123", 1231),
            OrderDetailsEntity(3, "ee123", 1231),
            OrderDetailsEntity(4, "rr123", 1231),
            OrderDetailsEntity(5, "rr132", 1231),
            OrderDetailsEntity(6, "tt123", 1231),
            OrderDetailsEntity(7, "yy132", 1231)
        )

    suspend fun showMsg(msg: String) {
        msg.e("--->>>")
        withContext(Dispatchers.Main) {
            msg.showToast()
        }
    }


    companion object {
        fun startaction(mContext: Context) {
            val mIntent =
                Intent().apply() {
                    setClass(mContext, OrderPagingActivity::class.java)
                }
            mContext.startActivity(mIntent)
        }
    }

}