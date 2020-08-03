package com.thedung.mvvmstructure.utils

import android.util.Log


class LogUtil {

    private fun getLineNumber(): Int {
        return try {
            Thread.currentThread().stackTrace[4].lineNumber
        } catch (e: Exception) {
            0
        }
    }

    fun i(tag: String?, message: String?) {
        debug {
            Log.i(tag, String.format("[Line: %d]%s", getLineNumber(), message))
        }

    }

    fun d(tag: String?, message: String?) {
        debug {
            Log.d(tag, String.format("[Line: %d]%s", getLineNumber(), message))
        }
    }

    fun e(tag: String?, message: String?) {
        debug {
            Log.e(tag, String.format("[Line: %d]%s", getLineNumber(), message))
        }
    }

    fun e(tag: String?, message: String?, e: Exception?) {
        debug {
            Log.i(tag, String.format("[Line: %d]%s", getLineNumber(), message), e)
        }
    }

    fun e(tag: String?, e: Exception) {
        debug {
            Log.i(tag, String.format("[Line: %d]%s", getLineNumber(), e.message), e)
        }
    }

    fun v(tag: String?, message: String?) {
        debug {
            Log.v(tag, String.format("[Line: %d]%s", getLineNumber(), message))
        }
    }

    fun w(tag: String?, message: String?) {
        debug {
            Log.w(tag, String.format("[Line: %d]%s", getLineNumber(), message))
        }
    }

}