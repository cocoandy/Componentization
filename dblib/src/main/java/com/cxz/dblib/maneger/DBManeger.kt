package com.cxz.dblib.maneger


import androidx.room.Room
import com.cxz.common.base.BaseApplication
import com.cxz.common.spread.e
import com.cxz.dblib.base.DataBase

object DBManeger {
    val DB_NAME = "db_order"

    val db: DataBase by lazy {
        "我只实例化一次哦".e("TAG_Room")
        Room.databaseBuilder(
            BaseApplication.mApplication,
            DataBase::class.java, DB_NAME
        ).build()
    }

}