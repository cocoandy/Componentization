package com.cxz.dblib.dao

import androidx.paging.DataSource
import androidx.paging.PagedList
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cxz.dblib.entity.OrderDetailsEntity
import com.cxz.dblib.entity.OrderEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface OrderDAO {

    @Query("SELECT * FROM OrderEntity")
    fun getOrderList(): MutableList<OrderEntity>



    @Query("SELECT * FROM OrderEntity ORDER BY date DESC")
    fun getOrders(): DataSource.Factory<Int, OrderEntity>

//    @Query("SELECT * FROM OrderEntity ORDER BY date DESC")
//    fun getOrderFlows(): Flow<PagedList<OrderEntity>>


    @Insert
    fun insertOrderEntity(orderEntity: OrderEntity)

    @Insert
    fun insertOrderEntitys(orderEntitys: MutableList<OrderEntity>)


    @Query("SELECT * FROM OrderDetailsEntity")
    fun getOrderDetails(): MutableList<OrderDetailsEntity>

    @Insert
    fun insertOrderDetailsEntitys(orderDetailsEntitys: MutableList<OrderDetailsEntity>)

}