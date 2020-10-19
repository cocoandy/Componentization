package com.cxz.order.ui.activity

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import com.cxz.common.base.BaseActivity
import com.cxz.common.spread.*
import com.cxz.order.R
import com.cxz.order.databinding.OrderHttpActivityBinding
import com.cxz.order.ui.viewmodel.OrderViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.base_toolbar.*

class OrderHttpActivity : BaseActivity() {
    override fun initLayout(): Int = R.layout.order_http_activity
    override fun initContentView() {
        binding = setBiningContentView<OrderHttpActivityBinding> {
            it.lifecycleOwner = this
            it.viewmodel = viewModel
            it.gson = Gson()
        }
        mToolBar.init(activity = this, icon = R.mipmap.ic_back) {
            setTitle("Extend")
        }
    }


    private val viewModel by viewModels<OrderViewModel>()
    private var binding: OrderHttpActivityBinding? = null

    override fun initView() {
    }

    override fun initData() {


    }

    override fun initViewEvent() {

    }

    companion object {
        fun startaction(mContext: Context) {
            val mIntent = Intent()
            mIntent.setClass<OrderHttpActivity>()
            mContext.startActivity(mIntent)
        }
    }

}
