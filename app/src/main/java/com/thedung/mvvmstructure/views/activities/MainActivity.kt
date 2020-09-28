package com.thedung.mvvmstructure.views.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thedung.mvvmstructure.R
import com.thedung.mvvmstructure.bases.BaseActivity
import com.thedung.mvvmstructure.services.Status
import com.thedung.mvvmstructure.utils.LogUtil
import com.thedung.mvvmstructure.views.adapter.test.TestApiAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class MainActivity : BaseActivity() {
    private val viewModel: MainViewModel by viewModels()
    private var adapter = TestApiAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun initView() {
//        btnGetData.setOnClickListener {
//            rcvTestApi.adapter = adapter
//            rcvTestApi.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
//            viewModel.triggerTestData()
//        }
    }

    override fun observerData() {
        viewModel.testData.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    btnGetData.text = "Success"
                    adapter.submitData(it.data ?: emptyList())
                }

                Status.LOADING -> {
                    btnGetData.text = "Loading"
                }

                Status.FAILED -> {
                    btnGetData.text = it.errorMessage
                }
            }
        })
    }
}