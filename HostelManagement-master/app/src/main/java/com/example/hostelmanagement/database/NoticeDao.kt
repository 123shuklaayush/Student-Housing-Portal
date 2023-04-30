package com.example.hostelmanagement.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoticeDao {

    @Query("SELECT * FROM studentnotice")
    fun getAllNotice(): LiveData<List<StudentNotice>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNotice(notice: StudentNotice)

    @Delete
    suspend fun deleteNotice(notice: StudentNotice)
}