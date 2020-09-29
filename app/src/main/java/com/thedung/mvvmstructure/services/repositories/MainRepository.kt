package com.thedung.mvvmstructure.services.repositories

import android.content.Context
import com.thedung.mvvmstructure.database.test.TestDao
import com.thedung.mvvmstructure.services.MainService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Singleton
class MainRepository @Inject constructor(
    private val mainService: MainService,
    private val context: Context,
    private val testDao: TestDao
)