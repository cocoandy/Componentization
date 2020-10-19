package com.cxz.common.util

import android.util.Log

class Logger {

    fun error(value: String, tag: String) {
        Log.e(tag, value)
    }
}