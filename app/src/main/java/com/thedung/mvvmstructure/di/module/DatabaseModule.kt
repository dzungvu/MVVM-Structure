package com.thedung.mvvmstructure.di.module

import android.content.Context
import androidx.room.Room
import com.thedung.mvvmstructure.database.AppMemoryDatabase
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {
    @Provides
    @Reusable
    fun providesAppMemoryDatabase(context: Context) =
        Room.inMemoryDatabaseBuilder(context, AppMemoryDatabase::class.java).build()

    @Provides
    @Reusable
    fun providesTestDao(appDataBase: AppMemoryDatabase) = appDataBase.testDao()
}