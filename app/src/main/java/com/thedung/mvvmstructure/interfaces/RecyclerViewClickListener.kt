package com.thedung.mvvmstructure.interfaces

import android.os.Bundle
import android.view.View


interface RecyclerViewClickListener<T> {
    fun onItemClick(pos: Int, data: T?)

    fun onSubItemClick(pos: Int, view: View, data: T?)

    fun onSubItemClick(pos: Int, view: View?, data: Bundle?)
}