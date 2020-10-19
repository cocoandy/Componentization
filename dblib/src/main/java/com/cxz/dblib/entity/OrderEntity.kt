package com.cxz.dblib.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class OrderEntity(


    val msg: String?,
    val date: Long?,
    @PrimaryKey(autoGenerate = true) val orderId: Int =0

) : Parcelable {

}
