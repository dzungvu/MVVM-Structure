package com.thedung.mvvmstructure.views.adapter.test

import android.view.View
import com.thedung.mvvmstructure.bases.BaseViewHolder
import com.thedung.mvvmstructure.interfaces.RecyclerViewClickListener
import com.thedung.mvvmstructure.models.TestData
import kotlinx.android.synthetic.main.item_test_api.*
import java.util.*

class TestApiViewHolder(itemView: View, itemClickListener: RecyclerViewClickListener<TestData>?) :
    BaseViewHolder<TestData>(itemView, itemClickListener) {
    override fun bind() {
        tvName.text = data?.name
        tvAge.text = String.format(Locale.US, "Age: ${data?.age}")
    }

    override fun update(payload: Any?) {

    }

}