package com.cxz.common.spread

import android.util.Log
import android.widget.Toast
import androidx.annotation.MainThread
import com.cxz.common.base.BaseApplication
import com.google.gson.Gson

@MainThread
fun <T> T.showToast() {
    Toast.makeText(BaseApplication.mApplication, Gson().toJson(this), Toast.LENGTH_SHORT).show()
}


