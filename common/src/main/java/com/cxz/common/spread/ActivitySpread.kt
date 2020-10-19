package com.cxz.common.spread

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.cxz.common.base.BaseActivity


fun <T : ViewDataBinding?> BaseActivity.setBiningContentView(
    block: (T) -> Unit
): T {
    val bining = DataBindingUtil.setContentView<T>(this, initLayout())
    block(bining)
    return bining
}

fun BaseActivity.setBiningContentView() {
    setContentView(initLayout())
}


//简化跳转
inline fun <reified T : Activity> Activity.toActivity(block: Intent.() -> Unit) {
    baseContext.toActivity<T>(block)
}

//简化跳转
inline fun <reified T : Activity> Context.toActivity(block: Intent.() -> Unit) {
    val intent = Intent(this, T::class.java)
    block(intent)
    this.startActivity(intent)
}

inline fun <reified T : Activity> Fragment.toActivity(block: Intent.() -> Unit) {
    context?.toActivity<T>(block)
}

