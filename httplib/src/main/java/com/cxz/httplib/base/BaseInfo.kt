package com.cxz.httplib.base

data class BaseInfo<T>(
    val code: Int = 0,
    val msg: String? = null,
    val totalPage: Int = 0,
    val totalRecord: Int = 0,
    val data: T? = null
)