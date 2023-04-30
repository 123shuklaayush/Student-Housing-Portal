package com.example.hostelmanagement.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {

    @Query("SELECT * FROM STUDENT ")
    fun getStudentDetails(): LiveData<List<Student>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: Student)

    @Query("SELECT * FROM STUDENT WHERE name=(:name) and usn=(:usn)")
    suspend fun verifyLogin(name: String, usn: String): Student

    @Update
    suspend fun updateAttendence(student: Student)

}