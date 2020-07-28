package com.thedung.mvvmstructure.di.module

object NetworkModule {
    init {
        System.loadLibrary("app-values")
    }


    private external fun getBaseUrl(debug: Boolean): String
}