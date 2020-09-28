package com.thedung.mvvmstructure.views.activities

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.thedung.mvvmstructure.bases.BaseModel
import com.thedung.mvvmstructure.services.repositories.MainRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class MainViewModel @ViewModelInject constructor(repository: MainRepository) : BaseModel() {
    private val mTestData = MutableLiveData<Any>()
    val testData = Transformations.switchMap(mTestData) {
        repository.getTestData().asLiveData(viewModelScope.coroutineContext)
    }

    fun triggerTestData() {
        mTestData.postValue(null)
    }
}