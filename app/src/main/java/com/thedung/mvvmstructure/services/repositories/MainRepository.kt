package com.thedung.mvvmstructure.services.repositories

import android.content.Context
import com.thedung.mvvmstructure.models.TestData
import com.thedung.mvvmstructure.services.MainService
import com.thedung.mvvmstructure.services.Resource
import com.thedung.mvvmstructure.services.adapter.NetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Singleton
class MainRepository @Inject constructor(
    private val mainService: MainService,
    private val context: Context
) {
    fun getTestData() = flow<Resource<List<TestData>>> {
        val response = mainService.getTestData()
        when (response) {
            is NetworkResponse.Success -> {
                emit(Resource.Success(response.body))
            }
            else -> {
                throw response.toError()
            }
        }
    }.onStart {
        emit(Resource.Loading())
    }.catch {
        it.printStackTrace()
        emit(Resource.Error(errorMessage = it.message))
    }.flowOn(Dispatchers.IO)
}