package com.thedung.mvvmstructure.database.test

import androidx.room.*

@Entity(tableName = "Test")
data class TestDataBase(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "age")
    var age: Int
)

@Dao
abstract class TestDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertTest(test: TestDataBase)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertTests(list: List<TestDataBase>)

    @Query("SELECT * FROM Test")
    abstract fun getAllTest(): List<TestDataBase>
}