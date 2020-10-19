package com.cxz.common.spread

import android.util.Log
import com.google.gson.Gson

fun <T> T?.e(tag: String) {
    Log.e(tag, this?.toString())

}

fun <T> T?.w(tag: String) {
    Log.e(tag, Gson().toJson(this))
}

