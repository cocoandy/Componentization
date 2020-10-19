package com.cxz.common.spread

import android.content.Intent
import com.cxz.common.base.BaseApplication

inline fun <reified T> Intent.setClass() {
    setClass(BaseApplication.mApplication, T::class.java)
}