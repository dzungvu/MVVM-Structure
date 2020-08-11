package com.thedung.mvvmstructure.services.repositories

import android.content.Context
import com.thedung.mvvmstructure.database.test.TestDao
import com.thedung.mvvmstructure.database.test.TestDataBase
import com.thedung.mvvmstructure.models.TestData
import com.thedung.mvvmstructure.services.MainService
import com.thedung.mvvmstructure.services.Resource
import com.thedung.mvvmstructure.services.adapter.NetworkResponse
import com.thedung.mvvmstructure.utils.LogUtil
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
    private val context: Context,
    private val testDao: TestDao
) {
    fun getTestData() = flow<Resource<List<TestData>>> {
        val response = mainService.getTestData()
        when (response) {
            is NetworkResponse.Success -> {
                emit(Resource.Success(response.body))
                val testArr = arrayListOf<TestDataBase>()
                for (item in response.body) {
                    LogUtil.i("MainRepository", item.name)
                    testArr.add(TestDataBase(id = item.id, name = item.name, age = item.age))
                }

                testDao.insertTests(testArr)
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