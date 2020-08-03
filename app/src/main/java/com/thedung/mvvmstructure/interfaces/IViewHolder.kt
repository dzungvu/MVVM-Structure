package com.thedung.mvvmstructure.interfaces


interface IViewHolder<T> {
    var data: T?

    fun set(data: T?)

    fun bind()

    fun update(payload: Any?)
}