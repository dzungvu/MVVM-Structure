package com.thedung.mvvmstructure.services

import com.thedung.mvvmstructure.models.TestData
import retrofit2.http.GET

interface MainService {
    @GET("getTestData/")
    suspend fun getTestData(): List<TestData>
}