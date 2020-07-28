package com.thedung.mvvmstructure.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Application : Application() {
    companion object {
        lateinit var INSTANCE: Application
    }

    init {
        INSTANCE = this
    }
}