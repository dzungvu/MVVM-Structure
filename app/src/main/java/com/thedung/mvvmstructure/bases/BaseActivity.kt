package com.thedung.mvvmstructure.bases

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    abstract fun initView()
    abstract fun observerData()

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        initView()
        observerData()
    }
}