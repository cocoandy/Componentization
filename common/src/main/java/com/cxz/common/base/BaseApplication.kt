package com.cxz.common.base

import android.app.Application

open class BaseApplication : Application() {

    companion object {
        lateinit var mApplication: Application
    }

    override fun onCreate() {
        super.onCreate()
        mApplication = this
    }

}