package com.thedung.mvvmstructure.utils

import com.thedung.mvvmstructure.BuildConfig

/**
 * Run @param task() block if in debug mode ]
 */
inline fun debug(task: () -> Unit) {
    if (BuildConfig.DEBUG) {
        task()
    }
}