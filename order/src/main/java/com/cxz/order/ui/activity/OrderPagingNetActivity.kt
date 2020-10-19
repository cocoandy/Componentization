package com.cxz.order.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cxz.common.base.BaseActivity
import com.cxz.common.spread.setBiningContentView
import com.cxz.order.R

class OrderPagingNetActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_paging_net_activity)
    }

    override fun initLayout(): Int = R.layout.order_paging_net_activity

    override fun initContentView() {
        setBiningContentView()
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initViewEvent() {
    }
}