package com.cxz.order.demo

import androidx.fragment.app.Fragment
import com.cxz.common.base.BaseActivity
import com.cxz.order.R

class Faction : BaseActivity() {
    override fun initLayout(): Int {
        TODO("Not yet implemented")
    }

    override fun initContentView() {
        supportFragmentManager.beginTransaction().add(R.id.mTvOrderId,Fragment(), "")
    }

    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun initData() {
        TODO("Not yet implemented")
    }

    override fun initViewEvent() {
        TODO("Not yet implemented")
    }

}