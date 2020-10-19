package com.cxz.order.ui.activity

import android.content.Context
import android.content.Intent
import com.cxz.common.base.BaseActivity
import com.cxz.common.spread.setBiningContentView
import com.cxz.order.R
import kotlinx.android.synthetic.main.base_toolbar.*

class OrderCoordinatorActivity : BaseActivity() {
    override fun initLayout(): Int = R.layout.order_coordinator_layout_activity
    override fun initContentView() {
        setBiningContentView()
    }

    companion object {
        fun startaction(mContext: Context) {
            val mIntent =
                Intent().apply() {
                    setClass(mContext, OrderCoordinatorActivity::class.java)
                }
            mContext.startActivity(mIntent)
        }
    }


    override fun initView() {
        setBarHeightAndPadding(mToolBar)
        setNavigationOnClick(mToolBar, R.mipmap.ic_back)
    }

    override fun initData() {
    }

    override fun initViewEvent() {
    }
}
