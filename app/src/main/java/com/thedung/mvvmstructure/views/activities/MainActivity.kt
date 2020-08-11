package com.thedung.mvvmstructure.views.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.thedung.mvvmstructure.R
import com.thedung.mvvmstructure.bases.BaseActivity
import com.thedung.mvvmstructure.services.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class MainActivity : BaseActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun initView() {
        btnGetData.setOnClickListener {
            tvCenter.text = ""
            viewModel.triggerTestData()
        }
    }

    override fun observerData() {
        viewModel.testData.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    tvCenter.text = it.data?.toString()
                }

                Status.LOADING -> {
                    tvCenter.text = "Loading"
                }

                Status.FAILED -> {
                    tvCenter.text = it.errorMessage
                }
            }
        })
    }
}