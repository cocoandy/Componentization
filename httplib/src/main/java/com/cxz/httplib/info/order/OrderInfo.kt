package com.cxz.httplib.info.order

data class OrderInfo(
    val orderNum: Int = 0,
    val list: MutableList<OrerDeidleInfo>? = null
) 