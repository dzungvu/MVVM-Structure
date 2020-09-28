package com.thedung.mvvmstructure.bases

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.thedung.mvvmstructure.interfaces.IRecyclerViewAdapter


abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>(), IRecyclerViewAdapter<T> {
    override var listData: ArrayList<T> = ArrayList()

    private val mDiff by lazy { AsyncListDiffer<T>(this, diffCallback) }

    @Synchronized
    override fun getItemCount(): Int {
        return mDiff.currentList.size
    }

    @Synchronized
    protected fun getItem(pos: Int): T {
        return mDiff.currentList[pos]
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        val item = getItem(position)
        holder.set(item)
        holder.bind()
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder<T>,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty()) {
            val item = getItem(position)
            holder.set(item)
            holder.update(payloads[0])
        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    @Synchronized
    override fun submitData(data: List<T>) {
        mDiff.submitList(data)
    }

    @Synchronized
    override fun addItem(item: T, pos: Int?) {
        if (pos != null && pos in listData.indices) {
            mDiff.currentList.add(pos, item)
            notifyItemInserted(pos)
        } else {
            mDiff.currentList.add(item)
            notifyItemInserted(listData.size - 1)
        }
    }

    @Synchronized
    override fun addMore(data: List<T>) {
        val oldSize = mDiff.currentList.size
        if (data.isNotEmpty()) {
            mDiff.currentList.addAll(data)
            notifyItemRangeInserted(oldSize, mDiff.currentList.size - 1)
        }
    }
}