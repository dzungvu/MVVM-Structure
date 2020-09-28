package com.thedung.mvvmstructure.interfaces

import androidx.recyclerview.widget.DiffUtil


interface IRecyclerViewAdapter<T> {
    var listData: ArrayList<T>

    var diffCallback: DiffUtil.ItemCallback<T>

    fun submitData(data: List<T>)

    fun removeItem(pos: Int)

    fun addItem(item: T, pos: Int?) {}

    fun addMore(data: List<T>) {}
}