package com.cxz.common.spread

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.cxz.common.base.BaseActivity
import com.cxz.common.base.BaseFragment


fun <T : ViewDataBinding?> BaseFragment.setBiningContentView(
    container: ViewGroup?,
    block: (T) -> Unit
): T {
    val bining = DataBindingUtil.inflate<T>(layoutInflater, initLayout(), container, false)
    block(bining)
    return bining
}

fun BaseFragment.setBiningContentView(
    container: ViewGroup?
): View {
    return layoutInflater.inflate(initLayout(), container, false)
}


