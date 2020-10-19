package com.cxz.common.spread

import androidx.lifecycle.LiveDataScope
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

/**
 * livedata{}异常处理
 */
suspend fun <T> LiveDataScope<T>.api(dataScope: suspend () -> T) {
    withContext(Dispatchers.IO) {
        try {
            emit(dataScope.invoke())
        } catch (e: Exception) {
            Gson().toJson(e).e("CATCH_EXCEPTION")
            emit(null as T)
        }
    }
}

/**
 * 统一处理协程的异常（主要是网络请求）
 */
suspend fun <T> CoroutineScope.api(
    data: MutableLiveData<T>? = null,
    dataScope: suspend () -> T
): T {
    val value = withContext(context = Dispatchers.IO) {
        try {
            dataScope.invoke()
        } catch (e: Exception) {
            Gson().toJson(e).e("CATCH_EXCEPTION")
            null as T
        }
    }
    data?.value = value
    return value

}


fun <T> T.toGsonString(): String {
    return Gson().toJson(this)
}




