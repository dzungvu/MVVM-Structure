package com.thedung.mvvmstructure.bases

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async

abstract class BaseModel : ViewModel() {

    protected fun <T : Any> async(call: suspend () -> T): Deferred<T> {
        return viewModelScope.async {
            call()
        }
    }
}