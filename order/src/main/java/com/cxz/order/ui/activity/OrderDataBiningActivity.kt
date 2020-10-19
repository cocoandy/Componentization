package com.cxz.order.ui.activity

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.cxz.common.base.BaseActivity
import com.cxz.common.spread.setBiningContentView
import com.cxz.common.spread.init
import com.cxz.order.R
import com.cxz.order.ui.adapter.DataBiningAdapter
import com.cxz.order.ui.viewmodel.OrderViewModel
import kotlinx.android.synthetic.main.base_toolbar.*
import kotlinx.android.synthetic.main.order_data_bining_activity.*


class OrderDataBiningActivity : BaseActivity() {
    override fun initLayout(): Int = R.layout.order_data_bining_activity
    override fun initContentView() {
        setBiningContentView()
        mToolBar.init(activity = this, icon = R.mipmap.ic_back)
    }

    val viewmodel by viewModels<OrderViewModel>()

    override fun initView() {
        val adapter = DataBiningAdapter()
        mOrderRecycle.adapter = adapter
        viewmodel.modelOrder.observe(this, Observer {
            adapter.addDataAll(it.data?.list!!)
            adapter.notifyDataSetChanged()
        })
    }

    override fun initData() {
    }

    override fun initViewEvent() {

        viewmodel.modelOrder()
    }

    companion object {
        fun startaction(mContext: Context) {
            val mIntent =
                Intent().apply() {
                    setClass(mContext, OrderDataBiningActivity::class.java)
                }
            mContext.startActivity(mIntent)
        }
    }
}