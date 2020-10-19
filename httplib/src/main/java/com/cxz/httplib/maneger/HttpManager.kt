package com.cxz.httplib.maneger

import com.cxz.httplib.intercept.HeaderIntercept
import com.cxz.httplib.intercept.LoggingInterceptor
import com.cxz.httplib.api.HttpApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpManager {

    private val server: HttpApi by lazy { creatRetrofit()
        .creatServie<HttpApi>()}
    private val BASE_URL = "http://47.92.121.124:9011/"

    fun creatRetrofit(): Retrofit {
        //设置拦截器
        val cline =
            with(OkHttpClient.Builder()) {
                addInterceptor(HeaderIntercept())
                addInterceptor(LoggingInterceptor())
                build()
            }
        //获取Retrofit对象
        val retrofit = with(Retrofit.Builder()) {
            baseUrl(BASE_URL)
            addConverterFactory(GsonConverterFactory.create())
            client(cline)
            build()
        }

        return retrofit
    }



    fun getHttpService(): HttpApi {
        return server
    }
}