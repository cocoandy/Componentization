package com.cxz.common.base

interface BaseView {
    fun initLayout(): Int
    open fun initView()
    open fun initViewEvent()
    open fun initData()
}