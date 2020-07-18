package com.rtchubs.filmadmin.adapters

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<Type, ViewHolder : BaseViewHolder<Type>>(list: List<Type> = mutableListOf()) : RecyclerView.Adapter<ViewHolder>() {

    var items: MutableList<Type> = list.toMutableList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    fun updateData(mItemList: MutableList<Type>) {
        this.items = mItemList
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    /*override fun getItemId(position: Int): Long {
        return position.toLong()
    }*/

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position]) }