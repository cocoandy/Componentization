package com.cxz.httplib.intercept

import okhttp3.Interceptor
import okhttp3.Response

class HeaderIntercept :Interceptor{

    override fun intercept(chain: Interceptor.Chain): Response {
       val request = chain.request()
       val httpUrl = request.url().newBuilder()
        httpUrl.addQueryParameter("username","123123")
        httpUrl.build()
        request.newBuilder()
        return chain.proceed(request)
    }
}