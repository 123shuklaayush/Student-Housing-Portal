package com.example.hostelmanagement.database

import androidx.lifecycle.LiveData

class StudentRepository(private val studentDao: StudentDao) {

    fun getStudentDetails(): LiveData<List<Student>> {
        return studentDao.getStudentDetails()
    }

    suspend fun insert(student: Student) = studentDao.insert(student)

    suspend fun verifyLogin(name: String, usn: String): Student {
        return studentDao.verifyLogin(name, usn)
    }

    suspend fun updateAttendence(student: Student) {
        studentDao.updateAttendence(student)
    }
}