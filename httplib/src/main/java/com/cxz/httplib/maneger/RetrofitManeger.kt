package com.cxz.httplib.maneger

import retrofit2.Retrofit


inline fun <reified T> Retrofit.creatServie(): T = create(T::class.java)