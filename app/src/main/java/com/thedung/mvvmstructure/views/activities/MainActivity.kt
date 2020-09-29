package com.thedung.mvvmstructure.views.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.thedung.mvvmstructure.R
import com.thedung.mvvmstructure.bases.BaseActivity
import com.thedung.mvvmstructure.services.Resource
import com.thedung.mvvmstructure.utils.LogUtil
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class MainActivity : BaseActivity() {
    private val viewModel: MainViewModel by viewModels()
    private val TAG = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun initView() {
        btnGetData.setOnClickListener {
            viewModel.triggerCharacterContent()
        }
    }

    override fun observerData() {
        viewModel.characterData.observe(this, Observer {
            when (it) {
                is Resource.Loading -> {
                    LogUtil.d(TAG, "Loading")
                }
                is Resource.Success -> {
                    LogUtil.d(TAG, "Success with ${it.data}")
                }
                is Resource.Error -> {
                    LogUtil.d(TAG, it.errorMsg)
                }
            }
        })
    }
}