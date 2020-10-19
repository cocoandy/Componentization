package com.cxz.order.ui.activity

import android.content.Context
import com.cxz.common.base.BaseActivity
import com.cxz.common.spread.setBiningContentView
import com.cxz.common.spread.init
import com.cxz.common.spread.toActivity
import com.cxz.order.R
import kotlinx.android.synthetic.main.base_toolbar.*

class OrderCarViewActivity : BaseActivity() {
    override fun initLayout(): Int =
        R.layout.order_carview_activity

    override fun initContentView() {
        setBiningContentView()
        mToolBar.init(activity = this, icon = R.mipmap.ic_back, title = "CardView")

        lifecycle
    }


    override fun initView() {
    }

    override fun initData() {
    }

    override fun initViewEvent() {

    }

    companion object {
        fun startaction(mContext: Context) {
            mContext.toActivity<OrderCarViewActivity> {

            }
        }
    }

}
