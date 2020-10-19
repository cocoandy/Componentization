package com.cxz.dblib.base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cxz.dblib.dao.OrderDAO
import com.cxz.dblib.entity.OrderDetailsEntity
import com.cxz.dblib.entity.OrderEntity

@Database(entities = arrayOf(OrderEntity::class, OrderDetailsEntity::class), version = 3)
abstract class DataBase : RoomDatabase() {
    abstract fun orderDAO(): OrderDAO


}