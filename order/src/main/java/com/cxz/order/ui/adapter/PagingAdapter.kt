package com.cxz.order.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cxz.dblib.entity.OrderEntity
import com.cxz.order.R

import kotlinx.android.synthetic.main.order_pagelist_item.view.*

class PagingAdapter : PagedListAdapter<OrderEntity, PagingAdapter.PageViewHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.order_pagelist_item, parent, false)
        return PageViewHolder(view)
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        val data = getItem(position)
        holder.initData(data)
    }

    class PageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun initData(data: OrderEntity?) {
            data?.apply {
                itemView.mTvOrderId.text = orderId.toString()
                itemView.mTvOrderDate.text = date.toString()
                itemView.mTvOrderMsg.text = msg
            }

        }

    }


    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<OrderEntity>() {
            // Concert details may have changed if reloaded from the database,
            // but ID is fixed.
            override fun areItemsTheSame(
                oldConcert: OrderEntity,
                newConcert: OrderEntity
            ) = oldConcert.orderId == newConcert.orderId

            override fun areContentsTheSame(
                oldConcert: OrderEntity,
                newConcert: OrderEntity
            ) = oldConcert == newConcert
        }
    }
}