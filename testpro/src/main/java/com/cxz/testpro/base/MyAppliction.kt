package com.cxz.testpro.base

import com.cxz.common.base.BaseApplication
import com.squareup.leakcanary.LeakCanary

class MyAppliction :BaseApplication() {
    override fun onCreate() {
        super.onCreate()
//        if (!LeakCanary.isInAnalyzerProcess(this)) {
//            LeakCanary.install(this)
//        }
    }
}