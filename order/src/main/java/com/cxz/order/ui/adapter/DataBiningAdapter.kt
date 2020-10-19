package com.cxz.order.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.room.DatabaseView
import com.cxz.httplib.info.order.OrerDeidleInfo
import com.cxz.order.R
import com.cxz.order.databinding.OrderBiningItemBindingImpl

class DataBiningAdapter :
    RecyclerView.Adapter<DataViewHolder>() {

    var mutableList = mutableListOf<OrerDeidleInfo>()

    fun addDataAll(list: MutableList<OrerDeidleInfo>) {
        mutableList.addAll(list)
        notifyDataSetChanged()
    }

    fun addItem(item: OrerDeidleInfo) {
        mutableList.add(item)
        notifyItemChanged(mutableList.size - 1)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.order_bining_item, parent, false)
        return DataViewHolder(view)
    }

    override fun getItemCount(): Int = mutableList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bining?.order = mutableList.get(position)
    }


}

class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val bining: OrderBiningItemBindingImpl? = DataBindingUtil.bind(itemView)

}