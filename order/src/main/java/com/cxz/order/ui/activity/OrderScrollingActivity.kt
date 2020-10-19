package com.cxz.order.ui.activity

import android.content.Context
import android.content.Intent
import com.google.android.material.snackbar.Snackbar
import com.cxz.common.base.BaseActivity
import com.cxz.common.spread.setBiningContentView
import com.cxz.common.spread.init
import com.cxz.order.R
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.base_toolbar_scrolling.mToolBar
import kotlinx.android.synthetic.main.order_scrolling_activity.*

class OrderScrollingActivity : BaseActivity(), AppBarLayout.OnOffsetChangedListener {

    override fun initLayout(): Int = R.layout.order_scrolling_activity
    override fun initContentView() {
        setBiningContentView()
        mToolBar.init(activity = this, icon = R.mipmap.ic_back) {
            setTitle("Scrolling")
        }
    }

    companion object {
        fun startaction(mContext: Context) {
            val mIntent =
                Intent().apply() {
                    setClass(mContext, OrderScrollingActivity::class.java)
                }
            mContext.startActivity(mIntent)
        }
    }


    override fun initView() {
    }

    override fun initData() {

    }

    override fun initViewEvent() {
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {

    }
}
