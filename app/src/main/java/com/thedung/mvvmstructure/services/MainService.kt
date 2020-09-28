package com.thedung.mvvmstructure.services

import com.thedung.mvvmstructure.models.TestData
import com.thedung.mvvmstructure.services.adapter.RemoteResponse
import retrofit2.http.GET

interface MainService {
    @GET("getTestData/")
    suspend fun getTestData(): RemoteResponse<List<TestData>>
}