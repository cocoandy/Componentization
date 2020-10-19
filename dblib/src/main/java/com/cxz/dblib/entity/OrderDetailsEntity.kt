package com.cxz.dblib.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OrderDetailsEntity(

    @PrimaryKey val orderId: Int?,
    @ColumnInfo val msg: String?,
    @ColumnInfo val date: Long?

)