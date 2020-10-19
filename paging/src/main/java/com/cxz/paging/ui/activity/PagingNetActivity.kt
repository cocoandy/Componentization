package com.cxz.paging.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.cxz.common.base.BaseActivity
import com.cxz.common.spread.init
import com.cxz.paging.R
import com.cxz.paging.ui.adapter.PagingAdapter
import com.cxz.paging.ui.viewmodel.PagingModel
import kotlinx.android.synthetic.main.base_toolbar.*
import kotlinx.android.synthetic.main.paging_local_activity.*

class PagingNetActivity : BaseActivity() {
    override fun initLayout(): Int = R.layout.paging_net_activity

    val adapter by lazy { PagingAdapter() }
    val viewModel by viewModels<PagingModel>()
    override fun initView() {
        mOrderRecycle.adapter = adapter
        mToolBar.init(activity = this, icon = R.mipmap.ic_back) {
            setTitle("Net Paging")
        }
    }

    override fun initViewEvent() {

    }

    override fun initData() {

    }

}