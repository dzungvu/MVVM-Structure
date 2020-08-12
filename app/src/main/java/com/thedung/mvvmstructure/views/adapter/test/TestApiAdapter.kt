package com.thedung.mvvmstructure.views.adapter.test

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.thedung.mvvmstructure.R
import com.thedung.mvvmstructure.bases.BaseAdapter
import com.thedung.mvvmstructure.bases.BaseViewHolder
import com.thedung.mvvmstructure.models.TestData
import com.thedung.mvvmstructure.utils.extensions.inflate

class TestApiAdapter : BaseAdapter<TestData>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<TestData> {
        return TestApiViewHolder(parent.inflate(R.layout.item_test_api), null)
    }

    override var diffCallback: DiffUtil.ItemCallback<TestData> = object : DiffUtil.ItemCallback<TestData>() {
        override fun areItemsTheSame(oldItem: TestData, newItem: TestData): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: TestData, newItem: TestData): Boolean {
            return false
        }

    }

    override fun removeItem(pos: Int) {

    }

}