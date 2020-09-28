package com.thedung.mvvmstructure.bases

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.thedung.mvvmstructure.interfaces.IViewHolder
import com.thedung.mvvmstructure.interfaces.RecyclerViewClickListener
import kotlinx.android.extensions.LayoutContainer


abstract class BaseViewHolder<T>(
    itemView: View,
    private val itemClickListener: RecyclerViewClickListener<T>?
) :
    RecyclerView.ViewHolder(itemView), IViewHolder<T>, LayoutContainer {

    override val containerView: View?
        get() = itemView

    override var data: T? = null

    override fun set(data: T?) {
        this.data = data
    }

    protected fun itemClick(view: View? = null) {
        if (view == null) {
            itemClickListener?.onItemClick(layoutPosition, data)
        } else {
            itemClickListener?.onSubItemClick(layoutPosition, view, data)
        }
    }

    protected fun onItemClick(view: View?, data: Bundle?) {
        itemClickListener?.onSubItemClick(layoutPosition, view, data)
    }

}