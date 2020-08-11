package com.thedung.mvvmstructure.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.thedung.mvvmstructure.database.test.TestDao
import com.thedung.mvvmstructure.database.test.TestDataBase

@Database(entities = [TestDataBase::class], version = 1, exportSchema = false)
abstract class AppMemoryDatabase : RoomDatabase() {
    abstract fun testDao(): TestDao
}