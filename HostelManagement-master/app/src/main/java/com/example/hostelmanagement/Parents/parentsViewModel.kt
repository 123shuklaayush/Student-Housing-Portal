package com.example.hostelmanagement.Parents

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.hostelmanagement.database.HostelDatabase
import com.example.hostelmanagement.database.Student
import com.example.hostelmanagement.database.StudentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class parentsViewModel(application: Application) : AndroidViewModel(application) {

    private val studentRepository: StudentRepository
    var singleStudent: Student? = null


    init {
        val studentDao = HostelDatabase.getDatabase(application).getStudentDao()
        studentRepository = StudentRepository(studentDao)

    }

    fun verifyLogin(name: String, usn: String) {
        viewModelScope.launch {
            val student = studentRepository.verifyLogin(name, usn)
            withContext(Dispatchers.Main) {
                singleStudent = student
            }
        }
    }

}