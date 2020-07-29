package com.thedung.mvvmstructure.services.repositories

import android.content.Context
import androidx.lifecycle.liveData
import com.thedung.mvvmstructure.services.MainService
import com.thedung.mvvmstructure.services.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Singleton
class MainRepository @Inject constructor(private val mainService: MainService, private val context: Context) {
    fun getTestData() = liveData {
        emit(Resource.Loading())
        try {
            val response = mainService.getTestData()
            emit(Resource.Success(response))
        } catch (ex: Exception) {
            ex.printStackTrace()
            emit(Resource.Error(errorMessage = ex.message, errorCode = "1111"))
        }
    }
}